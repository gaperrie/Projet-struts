package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EntrepriseValidationForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String numSiret=null;
    private Integer contactId=null;

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
	 * @return the numSiret
	 */
	public String getNumSiret() {
		return numSiret;
	}

	/**
	 * @param numSiret the numSiret to set
	 */
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
          this.numSiret=null;
          this.contactId=null;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
            ActionErrors errors = new ActionErrors();
            return errors;
        }


}


