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
import actionForm.PhoneNumberValidationForm;
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

public class AddPhoneNumberAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
        
        final PhoneNumberValidationForm lForm=(PhoneNumberValidationForm)pForm;
            final String lPhoneKind = lForm.getPhoneKind();
            final String lphoneNumber = lForm.getPhoneNumber();
            final Integer lcontactId = lForm.getContactId();
            System.out.println("lForm.getContactId() : "+lForm.getContactId());
        	Contact lContact = new Contact();
        	lContact.setId(lcontactId);
        	PhoneNumber lPhoneNumber = new PhoneNumber(lPhoneKind, lphoneNumber, lContact);
	        final PhoneNumberService lPhoneNumberService = new PhoneNumberService();
	        final String lErrorPN = lPhoneNumberService.addPhoneNumber(lPhoneNumber);  
        
        if(lErrorPN == null) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
