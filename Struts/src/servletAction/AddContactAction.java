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
import actionForm.AddContactValidationForm;
import domain.Contact;
import services.ContactService;

/**
 * @author gaelp
 *
 */

public class AddContactAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
        
        final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
               
        final String firstName = lForm.getFirstName();
        final String lastName = lForm.getLastName();
        final String email = lForm.getEmail();        
        final Contact lContact = new Contact(firstName,lastName,email);
        
        // create a new Contact
        final ContactService lContactService = new ContactService();
        final String lError = lContactService.addContact(lContact);
       
        
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
