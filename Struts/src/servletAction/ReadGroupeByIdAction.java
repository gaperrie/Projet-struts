package servletAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import actionForm.ReadContactByIdValidationForm;
import domain.Address;
import domain.Contact;
import domain.Groupe;
import domain.PhoneNumber;
import services.AddressService;
import services.ContactGroupService;
import services.ContactService;
import services.EntrepriseService;
import services.PhoneNumberService;

public class ReadGroupeByIdAction extends Action {

    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) {
    	    	 
        Integer groupId = Integer.parseInt(pRequest.getParameter("groupId"));
    	System.out.println("groupId : "+groupId);
        final ContactService lContactService = new ContactService();
    	final ArrayList<Contact> contacts = lContactService.readContactByGroupe(groupId);
    	    	
    	pRequest.getSession().setAttribute("contacts", contacts);
    	
    	return pMapping.findForward("success");
    }
}
