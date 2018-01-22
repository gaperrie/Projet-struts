package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginValidationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String login = "Enter login";
	private String password = null;
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.login = null;
		this.password = null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(getLogin()==null || getLogin().length() < 1) {
			errors.add(login, new ActionMessage("error.login.login.required"));
		}
		
		if(getPassword()==null || getPassword().length() < 1) {
			errors.add(password, new ActionMessage("error.login.password.required"));
		}
		return errors;
	}
}
