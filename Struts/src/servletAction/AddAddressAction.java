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
import actionForm.ModifyAddressValidationForm;
import domain.Address;
import domain.Contact;
import services.AddressService;

/**
 * @author gaelp
 *
 */

public class AddAddressAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

        final ModifyAddressValidationForm lForm=(ModifyAddressValidationForm)pForm;
        
        Integer contactId= lForm.getContactId();
    	String country=lForm.getCountry();
        String street=lForm.getStreet();
        String city=lForm.getCity();
        String zip=lForm.getZip();
        Contact lContact = new Contact();
        lContact.setId(contactId);
        final Address lAddress = new Address(street, city, zip, country, lContact);
        System.out.println("lAddress Action : "+lAddress.toString());
        // update a new Address
        final AddressService lAddressService = new AddressService();
        final String lResult = lAddressService.addAddress(lAddress);

        if(lResult == null) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
