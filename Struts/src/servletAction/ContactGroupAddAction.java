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
import actionForm.AddGroupeValidationForm;
import actionForm.ContactGroupValidationForm;
import domain.ContactGroup;
import domain.Groupe;
import services.ContactGroupService;
import services.GroupeService;

/**
 * @author gaelp
 *
 */

public class ContactGroupAddAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
    	
    	final ContactGroupValidationForm lForm=(ContactGroupValidationForm)pForm;
    	String lErrorCG = null;
    	
    	if(lForm.getGroupId() != null) {
			final Integer [] groupId = lForm.getGroupId();
			final Integer contactId = lForm.getContactId();
        	for(Integer i=0; i<groupId.length;i++) {
        		//System.out.println("Action GroupID : "+groupId[i]+" ContactId : "+lError);
		        final ContactGroup lContactGroup = new ContactGroup(groupId[i], contactId);       
		        final ContactGroupService lContactGroupService = new ContactGroupService();
		        lErrorCG = lContactGroupService.addContactGroup(lContactGroup);
        	}
        }
        if(lErrorCG == null) {
            // if no exception is raised,  forward "success"
            return pMapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return pMapping.findForward("error");
        }
    }
}
