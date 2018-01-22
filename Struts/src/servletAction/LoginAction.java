package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.LoginValidationForm;
import services.UserService;

public class LoginAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		LoginValidationForm lForm = (LoginValidationForm)pForm;
		
		final String login = lForm.getLogin();
		final String password = lForm.getPassword();
		
		//Solution provisoire pour l'authentification
		//final String lError = (login.equals(password)) ? null : "error"; 
		
		UserService lUserService = new UserService();
		int lError = lUserService.check(login, password);
		
		if(lError > 0) {
			return pMapping.findForward("success");
		}
		else {
			return pMapping.findForward("error");			
		}
	}

}
