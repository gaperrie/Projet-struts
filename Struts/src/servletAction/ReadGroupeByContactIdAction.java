package servletAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import domain.Contact;
import domain.Groupe;
import services.ContactService;
import services.GroupeService;

public class ReadGroupeByContactIdAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
    	
    	Integer id= Integer.parseInt(pRequest.getParameter("contactId"));
    	
    	final GroupeService lGroupeService = new GroupeService();
    	final ArrayList<Groupe> groupes = lGroupeService.readGroupeByContactId(id);
    	
    	pRequest.getSession().setAttribute("groupes", groupes);
    	
    	return pMapping.findForward("success");
    }
}
