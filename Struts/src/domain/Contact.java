/**
 * 
 */
package domain;

/**
 * @author gaelp
 *
 */
public class Contact {
	Integer id;
	String firstName;
	String lastName;
	String email;
	Address address;
	Integer nbGroupe;
	
	/**
	 * 
	 */
	public Contact() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Contact(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the nbGroupe
	 */
	public Integer getNbGroupe() {
		return nbGroupe;
	}


	/**
	 * @param nbGroupe the nbGroupe to set
	 */
	public void setNbGroupe(Integer nbGroupe) {
		this.nbGroupe = nbGroupe;
	}
	
	
}
