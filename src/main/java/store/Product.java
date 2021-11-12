package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enums.ProdType;

@Entity
@Table(name="PRODUCT")
public class Product {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="CODE", length=8, nullable=false)
	private String code;
	
	@Column(name="LABEL", length=50, nullable=false)
	private String label;
	
	@Column(name="TYPE", length=50, nullable=false)
	@Enumerated(EnumType.STRING)
	private ProdType type;
	
	@Column(name="PRICE", length=6, nullable=false)
	private Double price;

	@ManyToMany(mappedBy="products")
	private List<PetStore> petStores = new ArrayList<>();
	
	//CONSTRUCTEURS
	public Product(String code, String label, ProdType type, Double price, ArrayList<PetStore> petStores) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
		this.petStores = petStores;
	}
	
	public Product() {
		super();
	}

	
	//GETTERS SETTERS
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public ProdType getType() {
		return type;
	}


	public void setType(ProdType type) {
		this.type = type;
	}


	public List<PetStore> getPetStores() {
		return petStores;
	}

	public void setPetStores(List<PetStore> petStores) {
		this.petStores = petStores;
	}

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void addPetStore(PetStore petStore) {
		petStores.add(petStore);
		petStore.addProduct(this);
	}

	
	//TOSTRING
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", label=" + label + ", type=" + type + ", price=" + price
				+ "]";
	}
	
	
	
}
