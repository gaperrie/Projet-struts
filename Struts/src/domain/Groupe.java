/**
 * 
 */
package domain;

import java.util.ArrayList;

/**
 * @author gaelp
 *
 */
public final class Groupe {
	Integer groupId;
	String groupName;
	Integer nbContact;
	ArrayList<Contact> contacts;
	
	
	/**
	 * 
	 */
	public Groupe() {
		super();
	}


	/**
	 * @param groupName
	 */
	public Groupe(String groupName) {
		super();
		this.groupName = groupName;
	}


	/**
	 * @param groupId
	 * @param groupName
	 */
	public Groupe(Integer groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}


	/**
	 * @param groupId
	 * @param groupName
	 * @param contacts
	 */
	public Groupe(Integer groupId, String groupName, ArrayList<Contact> contacts) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contacts = contacts;
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

	/**
	 * @return the nbContact
	 */
	public Integer getNbContact() {
		return nbContact;
	}


	/**
	 * @param nbContact the nbContact to set
	 */
	public void setNbContact(Integer nbContact) {
		this.nbContact = nbContact;
	}


	/**
	 * @return the contacts
	 */
	public ArrayList<Contact> getContacts() {
		return contacts;
	}


	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
}
