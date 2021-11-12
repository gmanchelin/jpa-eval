package store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NUMBER", length=4, nullable=false)
	private String number;
	
	@Column(name="STREET", length=60, nullable=false)
	private String street;
	
	@Column(name="ZIP_CODE", length=6, nullable=false)
	private String zipCode;
	
	@Column(name="CITY", length=40, nullable=false)
	private String city;

	@OneToOne(mappedBy = "address")
	private PetStore petStore;

	//CONSTRUCTEURS
	public Address(Long id, String number, String street, String zipCode, String city) {
		super();
		this.id = id;
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public Address(String number, String street, String zipCode, String city) {
		super();
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	public Address() {
		super();
	}
	
	
	//GETTERS SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PetStore getPetStore() {
		return petStore;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", zipCode=" + zipCode + ", city="
				+ city + "]";
	}

}
