package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ContactGroupValidationForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private Integer [] groupId =null;
    private Integer contactId=null;

	/**
	 * @return the groupId
	 */
	public Integer[] getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer[] groupId) {
		this.groupId = groupId;
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
	public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.groupId=null;
	}
	
	 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
         ActionErrors errors = new ActionErrors();
         return errors;
	 }
}
