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
import actionForm.AddGroupeValidationForm;
import domain.Groupe;
import services.GroupeService;

/**
 * @author gaelp
 *
 */

public class AddGroupeAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
        
        final AddGroupeValidationForm lForm=(AddGroupeValidationForm)pForm;               
        final String lGroupName = lForm.getGroupName();       
        final Groupe lGroupe = new Groupe(lGroupName);

        // create a new Groupe
        final GroupeService lGroupeService = new GroupeService();
        final String lError = lGroupeService.addGroupe(lGroupe);
    
        if(lError == null) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
