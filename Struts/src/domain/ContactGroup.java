/**
 * 
 */
package domain;

/**
 * @author gaelp
 *
 */
public class ContactGroup {
	Integer groupId;
	Integer contactId;
	
	
	/**
	 * 
	 */
	public ContactGroup() {
		super();
	}
	
	
	/**
	 * @param groupId
	 * @param contactId
	 */
	public ContactGroup(Integer groupId, Integer contactId) {
		super();
		this.groupId = groupId;
		this.contactId = contactId;
	}


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

	
}
