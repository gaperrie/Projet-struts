package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.DeleteWithIdValidationForm;
import services.ContactService;

public class DeleteContactAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
        
        final DeleteWithIdValidationForm lForm=(DeleteWithIdValidationForm)pForm;     
        final Integer id = Integer.parseInt(lForm.getId());
        
        // delete a Contact
        final ContactService lContactService = new ContactService();
        final Integer lResult = lContactService.deleteContact(id);
             
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
