package actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class AddContactGroupeValidationForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String firstName=null;
    private String lastName=null;
    private String email=null;
    private Integer [] groupId =null;
    private String street=null;
    private String city=null;
    private String country=null;
    private String zip=null;
    private String phoneNumber=null;
    private String phoneKind=null;
    private Integer numSiret=0;

    /**
     * @return Email
     */
    public String getEmail() {
      return email;
    }

    /**
     * @return First Name
     */
    public String getFirstName() {
      return firstName;
    }

    /** 
     * @return Last name
     */
    public String getLastName() {
      return lastName;
    }

    /**
     * @param string Sets the Email
     */
    public void setEmail(String string) {
      email = string;
    }

    /**
     * @param string Sets the First Name
     */
    public void setFirstName(String string) {
      firstName = string;
    }

    /**
     * @param string sets the Last Name
     */
    public void setLastName(String string) {
      lastName = string;
    }


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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
          this.firstName=null;
          this.lastName=null;
          this.email=null;
          this.groupId=null;
          this.street=null;
          this.city=null;
          this.country=null;
          this.zip=null;
          this.phoneKind=null;
          this.phoneNumber=null;
          this.numSiret=null;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
            ActionErrors errors = new ActionErrors();
            
            if( getFirstName()== null || getFirstName().length() < 1 ) {
              errors.add("firstName",new ActionMessage("error.addContact.firstname.required"));
            }
            if( getLastName()== null || getLastName().length() < 1 ) {
              errors.add("lastName",new ActionMessage("error.addContact.lastname.required"));
            }
            if( getEmail() == null || getEmail().length() < 1 ) {
              errors.add("email", new ActionMessage("error.addContact.email.required"));
            }
            
            /*if( getStreet()== null || getStreet().length() < 1 ) {
              errors.add("street",new ActionMessage("error.addContact.firstname.required"));
            }
            if( getCity()== null || getCity().length() < 1 ) {
              errors.add("city",new ActionMessage("error.addContact.lastname.required"));
            }
            if( getZip() == null || getZip().length() < 1 ) {
              errors.add("zip", new ActionMessage("error.addContact.email.required"));
            }
            if( getCountry() == null || getCountry().length() < 1 ) {
              errors.add("country", new ActionMessage("error.addContact.email.required"));
            }*/
            return errors;
        }
}


