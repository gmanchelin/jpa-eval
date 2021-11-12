package store;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import animal.Animal;

@Entity
@Table(name="PET_STORE")
public class PetStore {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	protected Long id;
	
	@Column(name="NAME", length=30, nullable=false)
	protected String name;
	
	@Column(name="MANAGER_NAME", length=40, nullable=false)
	protected String managerName;

	@ManyToMany
    @JoinTable(name="PET_PRO", 
    joinColumns= @JoinColumn(name="ID_PETSTORE", referencedColumnName="ID"), 
    inverseJoinColumns= @JoinColumn(name="ID_PRODUCT", referencedColumnName="ID"))
	private Set<Product> products = new HashSet<>();
	
	@OneToMany(mappedBy="petStore")
	private Set<Animal> animals = new HashSet<>();

	@OneToOne
	@JoinColumn(name="ADDRESS_ID", referencedColumnName = "ID")
	private Address address;
	
	//CONSTRUCTEURS	
	public PetStore(String name, String managerName, Address address) {
		super();
		this.name = name;
		this.managerName = managerName;
		this.address = address;
	}
	
	public PetStore(String name, String managerName, Address address, Set<Product> products) {
		super();
		this.name = name;
		this.managerName = managerName;
		this.address = address;
		this.products = products;
	}
	
	public PetStore() {
		super();
		animals = new HashSet<Animal>();
	}
	
	
	//GETTERS SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addProduct(Product product) {
		products.add(product);
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "PetStore [id=" + id + ", name=" + name + ", managerName=" + managerName + "]";
	}
	
}
