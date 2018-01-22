package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteWithIdValidationForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private String id=null;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
    
	public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.id=null;
	}
	
	 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
         ActionErrors errors = new ActionErrors();
         
         if( getId()== null || getId().length() < 1 ) {
           errors.add("id",new ActionMessage("error.addContact.id.required"));
         }
         return errors;
	 }
}
