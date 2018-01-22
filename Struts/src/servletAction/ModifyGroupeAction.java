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
import actionForm.ModifyGroupeValidationForm;
import domain.Groupe;
import services.GroupeService;

/**
 * @author gaelp
 *
 */

public class ModifyGroupeAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

        final ModifyGroupeValidationForm lForm=(ModifyGroupeValidationForm)pForm;
        
        final Integer lGroupId = lForm.getGroupId();
        final String lGroupName = lForm.getGroupName();        
        
        final Groupe lGroupe = new Groupe(lGroupId, lGroupName);
        // update a new Groupe
        final GroupeService lGroupeService = new GroupeService();
        final Integer lResult = lGroupeService.updateGroupe(lGroupe);

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
