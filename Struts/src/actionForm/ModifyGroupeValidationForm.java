/**
 * 
 */
package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author gaelp
 *
 */
public class ModifyGroupeValidationForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private Integer groupId=null;
	private String groupName=null;
	
	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.groupId=null;
        this.groupName=null;
  }
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
          ActionErrors errors = new ActionErrors();
          
          if( getGroupName()== null || getGroupName().length() < 1 ) {
            errors.add("groupName",new ActionMessage("error.addContact.lastname.required"));
          }
          	return errors;
      }	
}
