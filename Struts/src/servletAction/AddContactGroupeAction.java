/**
 * 
 */
package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.AddContactGroupeValidationForm;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;
import services.AddressService;
import services.ContactGroupService;
import services.ContactService;
import services.EntrepriseService;
import services.PhoneNumberService;

/**
 * @author gaelp
 *
 */

public class AddContactGroupeAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
        
        final AddContactGroupeValidationForm lForm=(AddContactGroupeValidationForm)pForm;
               
        final String firstName = lForm.getFirstName();
        final String lastName = lForm.getLastName();
        final String email = lForm.getEmail();        
        final Contact lContact = new Contact(firstName,lastName,email);
        
        // create a new Contact
        final ContactService lContactService = new ContactService();
        final String lError = lContactService.addContact(lContact);
        lContact.setId(Integer.parseInt(lError));
        
        if(lForm.getGroupId() != null) {
			final Integer [] groupId = lForm.getGroupId();
        	for(Integer i=0; i<groupId.length;i++) {
        		//System.out.println("Action GroupID : "+groupId[i]+" ContactId : "+lError);
		        final ContactGroup lContactGroup = new ContactGroup(groupId[i], Integer.parseInt(lError));       
		        final ContactGroupService lContactGroupService = new ContactGroupService();
		        final String lErrorCG = lContactGroupService.addContactGroup(lContactGroup);
        	}
        }
        
        if(lForm.getStreet().length() > 0  && lForm.getCity().length() > 0 && lForm.getZip().length() > 0 && lForm.getCountry().length() > 0) {
        	//System.out.println("street : "+lForm.getStreet()+" city : "+lForm.getCity()+" zip : "+lForm.getZip()+" country : "+lForm.getCountry());
            final String street = lForm.getStreet();
            final String city = lForm.getCity();
            final String zip = lForm.getZip(); 
            final String country = lForm.getCountry();
            Address lAddress = new Address(street, city, zip, country, lContact);
	        final AddressService lAddressService = new AddressService();
	        final String lErrorAdd = lAddressService.addAddress(lAddress);
	        lContact.setAddress(lAddress);
        }
        
        if(lForm.getPhoneNumber().length() > 0 && lForm.getPhoneKind().length() > 0) {
            final String lPhoneKind = lForm.getPhoneKind();
            final String lphoneNumber = lForm.getPhoneNumber();
        	PhoneNumber lPhoneNumber = new PhoneNumber(lPhoneKind, lphoneNumber, lContact);
	        final PhoneNumberService lPhoneNumberService = new PhoneNumberService();
	        final String lErrorPN = lPhoneNumberService.addPhoneNumber(lPhoneNumber);  
        }
        
        if(lForm.getNumSiret() > 0) {
        	final Integer lNumSiret = lForm.getNumSiret();
        	final EntrepriseService lEntrepriseService = new EntrepriseService();
        	final String lErrorE = lEntrepriseService.addEntreprise(lContact, lNumSiret);
        }
        
        if(Integer.parseInt(lError) > 0) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
