/**
 * 
 */
package domain;

/**
 * @author gaelp
 *
 */
public final class Entreprise {
	Integer numSiret;
	Contact contact;

	/**
	 * 
	 */
	public Entreprise() {
		super();
	}

	
	/**
	 * @param numSiret
	 * @param contact
	 */
	public Entreprise(Integer numSiret, Contact contact) {
		super();
		this.numSiret = numSiret;
		this.contact = contact;
	}



	/**
	 * @param numSiret
	 */
	public Entreprise(Integer numSiret) {
		super();
		this.numSiret = numSiret;
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


	/**
	 * @return the numSiret
	 */
	public Integer getNumSiret() {
		return numSiret;
	}

	/**
	 * @param numSiret the numSiret to set
	 */
	public void setNumSiret(Integer numSiret) {
		this.numSiret = numSiret;
	}
}
