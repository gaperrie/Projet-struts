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
import actionForm.ModifyContactValidationForm;
import actionForm.PhoneNumberValidationForm;
import domain.Contact;
import domain.PhoneNumber;
import services.ContactService;
import services.PhoneNumberService;

/**
 * @author gaelp
 *
 */

public class ModifyPhoneNumberAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

        final PhoneNumberValidationForm lForm=(PhoneNumberValidationForm)pForm;
        
        final String phoneNumber = lForm.getPhoneNumber();
        final String lPhoneKind = lForm.getPhoneKind();
        final Integer id = lForm.getId();
        final Integer contactId = lForm.getContactId();
        Contact lContact = new Contact();
        lContact.setId(contactId);
        
        final PhoneNumber lPhoneNumber = new PhoneNumber(id,phoneNumber,lPhoneKind, lContact);
        
        // update a new Contact
        final PhoneNumberService lPhoneNumberService = new PhoneNumberService();
        final Integer lResult = lPhoneNumberService.updatePhoneNumber(lPhoneNumber);

        if(lResult > 0) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
