package servletAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import actionForm.ReadContactByIdValidationForm;
import domain.Address;
import domain.Contact;
import domain.Groupe;
import domain.PhoneNumber;
import services.AddressService;
import services.ContactGroupService;
import services.ContactService;
import services.PhoneNumberService;

public class UpdateContactByIdAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
    	    	
        final ReadContactByIdValidationForm lForm=(ReadContactByIdValidationForm)pForm; 
        final Integer id = Integer.parseInt(lForm.getId());
    	
        final ContactService lContactService = new ContactService();
    	final Contact lContact = lContactService.showContact(id);
    	
    	final AddressService lAddressService = new AddressService();
    	final Address lAddress = lAddressService.showAddressByContact(id);
    	
    	final ContactGroupService lContactGroupService = new ContactGroupService();
    	final ArrayList<Groupe> groupes = lContactGroupService.readGroupeById(id);
    	
    	final PhoneNumberService lPhoneNumberService = new PhoneNumberService();
    	final ArrayList<PhoneNumber> phonenumbers = lPhoneNumberService.readPhoneNumberByContact(id);
    	System.out.println("street : "+lAddress.getStreet());
    	//final EntrepriseService lEntrepriseService = new EntrepriseService();
    	//final ArrayList<Entreprise> entreprises = EntrepriseService.readEntrepriseByContact(id);
    	
    	pRequest.getSession().setAttribute("lContact", lContact);
    	pRequest.getSession().setAttribute("lAddress", lAddress);
    	pRequest.getSession().setAttribute("groupes", groupes);
    	pRequest.getSession().setAttribute("phonenumbers", phonenumbers);
    	
    	return pMapping.findForward("success");
    }
}
