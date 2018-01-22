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

import actionForm.EntrepriseValidationForm;
import actionForm.ModifyGroupeValidationForm;
import domain.Contact;
import domain.Entreprise;
import domain.Groupe;
import services.EntrepriseService;
import services.GroupeService;

/**
 * @author gaelp
 *
 */

public class ModifyEntrepriseAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

        final EntrepriseValidationForm lForm=(EntrepriseValidationForm)pForm;
        
        final Integer contactId = lForm.getContactId();
        final String numSiret = lForm.getNumSiret(); 
        Contact lContact = new Contact();
        lContact.setId(contactId);
        final Entreprise lEntreprise = new Entreprise(Integer.parseInt(numSiret), lContact);
        // update a new Groupe
        final EntrepriseService lEntrepriseService = new EntrepriseService();
        final Integer lResult = lEntrepriseService.updateEntreprise(lEntreprise);

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
