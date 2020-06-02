package practica.sii.Clases;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Embeddable
public class Address implements Serializable {

	
	private String street1; 
	private String street2;
	private String city;
	private String state;
	private Long zipcode;
	private String country;
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}
	public Address(String street1,String street2, String city, String state, Long zipcode, String country) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state; 
		this.zipcode = zipcode;
		this.country = country;
	}
	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}   
	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}   
	public Long getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String toString() {
		return street1 + " " + zipcode + " " + city + " " + country;
	}
   
}
