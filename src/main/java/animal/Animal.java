package animal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import store.PetStore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Animal {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	protected Long id;
	
	@Column(name="BIRTH", length=10, nullable=false, columnDefinition="DATE")
	protected Date birth;
	
	@Column(name="COLOR", length=15, nullable=false)
	protected String color;

	@ManyToOne
	@JoinColumn(name="ID_PETSTORE")
	protected PetStore petStore;
	
	//CONSTRUCTEURS
	public Animal(Date birth, String color, PetStore petStore) {
		super();
		this.birth = birth;
		this.color = color;
		this.petStore = petStore;
	}
	
	public Animal() {
	}

	
	//GETTERS SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		return "Animal [id=" + id + ", birth=" + birth + ", color=" + color + "]";
	}

	
	
}
