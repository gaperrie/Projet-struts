package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ModifyContactValidationForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer id=null;
	private String firstName=null;
    private String lastName=null;
    private String email=null;

    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * @return Email
     */
    public String getEmail() {
      return email;
    }

    /**
     * @return First Name
     */
    public String getFirstName() {
      return firstName;
    }

    /** 
     * @return Last name
     */
    public String getLastName() {
      return lastName;
    }

    /**
     * @param string Sets the Email
     */
    public void setEmail(String string) {
      email = string;
    }

    /**
     * @param string Sets the First Name
     */
    public void setFirstName(String string) {
      firstName = string;
    }

    /**
     * @param string sets the Last Name
     */
    public void setLastName(String string) {
      lastName = string;
    }

    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
          this.firstName=null;
          this.lastName=null;
          this.email=null;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
            ActionErrors errors = new ActionErrors();
            
            if( getFirstName()== null || getFirstName().length() < 1 ) {
              errors.add("firstName",new ActionMessage("error.addContact.firstname.required"));
            }
            if( getLastName()== null || getLastName().length() < 1 ) {
              errors.add("lastName",new ActionMessage("error.addContact.lastname.required"));
            }
            if( getEmail() == null || getEmail().length() < 1 ) {
              errors.add("email", new ActionMessage("error.addContact.email.required"));
            }
            return errors;
        }
}


