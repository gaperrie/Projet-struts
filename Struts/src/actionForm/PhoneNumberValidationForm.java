package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class PhoneNumberValidationForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String phoneNumber=null;
    private String phoneKind=null;
    private Integer contactId=null;
    private Integer id=null;
    /**
     * @return Email
     */

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the phoneKind
	 */
	public String getPhoneKind() {
		return phoneKind;
	}

	/**
	 * @param phoneKind the phoneKind to set
	 */
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
          this.phoneKind=null;
          this.phoneNumber=null;
          this.contactId=null;
          this.id=null;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
            ActionErrors errors = new ActionErrors();
            
            if( getPhoneNumber()== null || getPhoneNumber().length() < 1 ) {
              errors.add("phoneNumber",new ActionMessage("error.addContact.firstname.required"));
            }
            if( getPhoneKind()== null || getPhoneKind().length() < 1 ) {
              errors.add("phoneKind",new ActionMessage("error.addContact.lastname.required"));
            }
            return errors;
        }
}


