package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.DeleteWithIdValidationForm;
import domain.ContactGroup;
import services.ContactGroupService;
import services.ContactService;

public class DeleteContactGroupAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {

    	Integer groupId = Integer.parseInt(pRequest.getParameter("groupId"));
    	Integer contactId = Integer.parseInt(pRequest.getParameter("contactId"));
    	
    	System.out.println("groupId : "+groupId);
    	System.out.println("contactId : "+contactId);
    	
        final ContactGroup lContactGroup = new ContactGroup(groupId, contactId);       
        final ContactGroupService lContactGroupService = new ContactGroupService();
        final Integer lResult = lContactGroupService.deleteContactGroup(lContactGroup);
   
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
