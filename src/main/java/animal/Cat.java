package animal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import store.PetStore;

@Entity(name = "CAT")
public class Cat extends Animal {
	
	//ATTRIBUTS
	@Column(name="CHIPID", length=20, nullable=false)
	private String chipId;

	
	//CONSTRUCTEURS
	public Cat(Date birth, String color, String chipId, PetStore petStore) {
		super(birth, color, petStore);
		this.chipId = chipId;
	}

	public Cat() {
		super();
	}

	
	//GETTERS SETTERS
	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	
	//TOSTRING
	@Override
	public String toString() {
		return "Cat ID : " + id + "; birthdate : " + birth + "; Color(s) : " + color + "; Chip ID : " + chipId;
	}
	
}
