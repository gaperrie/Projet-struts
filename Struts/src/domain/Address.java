/**
 * 
 */
package domain;

/**
 * @author gaelp
 *
 */
public final class Address {
	Integer id;
	String street;
	String city;
	String zip;
	String country;
	Contact contact;
	
	/**
	 * 
	 */
	public Address() {
		super();
	}
	
	/**
	 * @param id
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 */
	public Address(Integer id, String street, String city, String zip, String country) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}


	/**
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 */
	public Address(String street, String city, String zip, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	/**
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 * @param contact
	 */
	public Address(String street, String city, String zip, String country, Contact contact) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.contact = contact;
	}

	/**
	 * @param id
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 * @param contact
	 */
	public Address(Integer id, String street, String city, String zip, String country, Contact contact) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.contact = contact;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + ", country=" + country
				+ ", contact=" + contact + "]";
	}
	
	
}
