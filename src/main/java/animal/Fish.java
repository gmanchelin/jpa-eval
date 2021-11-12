package animal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.FishLivEnv;
import store.PetStore;

@Entity(name = "FISH")
public class Fish extends Animal {

	//ATTRIBUTS
	@Column(name="LIVING_ENV", length=20, nullable=false)
	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;

	
	//CONSTRUCTEURS	
	public Fish(Date birth, String color, PetStore petStore, FishLivEnv livingEnv) {
		super(birth, color, petStore);
		this.livingEnv = livingEnv;
	}
	
	public Fish() {
		super();
	}

	
	//GETTERS SETTERS
	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}

	
	//TOSTRING
	@Override
	public String toString() {
		return "Fish ID : " + id + "; birthdate : " + birth + "; Color(s) : " + color + "; Living Environment : " + livingEnv;
	}
	
	
	
}
