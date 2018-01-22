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
import domain.Contact;
import services.ContactService;

/**
 * @author gaelp
 *
 */

public class ModifyContactAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

        final ModifyContactValidationForm lForm=(ModifyContactValidationForm)pForm;
        
        final Integer lId = lForm.getId();
        final String lFirstName = lForm.getFirstName();
        final String lLastName = lForm.getLastName();
        final String lEmail = lForm.getEmail();
        
        
        final Contact lContact = new Contact(lId, lFirstName,lLastName, lEmail);
        
        // update a new Contact
        final ContactService lContactService = new ContactService();
        final Integer lResult = lContactService.updateContact(lContact);

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
