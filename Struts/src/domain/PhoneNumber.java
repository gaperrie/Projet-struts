/**
 * 
 */
package domain;

/**
 * @author gaelp
 *
 */
public final class PhoneNumber {
	Integer id;
	String phoneKind;
	String phoneNumber;
	Contact contact;
	
	/**
	 * 
	 */
	public PhoneNumber() {
		super();
	}


	/**
	 * @param id
	 * @param phoneKind
	 * @param phoneNumber
	 */
	public PhoneNumber(Integer id, String phoneKind, String phoneNumber) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @param id
	 * @param phoneKind
	 * @param phoneNumber
	 * @param contact
	 */
	public PhoneNumber(Integer id, String phoneKind, String phoneNumber, Contact contact) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}


	/**
	 * @param phoneKind
	 * @param phoneNumber
	 * @param contact
	 */
	public PhoneNumber(String phoneKind, String phoneNumber, Contact contact) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
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
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}


	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
