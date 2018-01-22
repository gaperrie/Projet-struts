package servletAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import domain.Contact;
import services.ContactService;

public class ReadContactAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
    	
    	final ContactService lContactService = new ContactService();
    	final ArrayList<Contact> contacts = lContactService.readContact();
    	pRequest.getSession().setAttribute("contacts", contacts);
    	return pMapping.findForward("success");
    }

}
