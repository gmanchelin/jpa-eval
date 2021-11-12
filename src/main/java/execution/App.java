package execution;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import animal.Animal;
import animal.Cat;
import animal.Fish;
import store.Address;
import store.PetStore;
import store.Product;
import enums.FishLivEnv;
import enums.ProdType;

public class App {

	public static void main(String[] args) {

		//Insertion de 3 enregistrements par table avec EntityManager
		EntityManagerFactory emf = null; 
		EntityManager em = null; 
		EntityTransaction et = null; 

		try {
			emf = Persistence.createEntityManagerFactory("jpa-eval");
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			//ADRESSES
			Address address1 = new Address();
			address1.setNumber("123");
			address1.setStreet("Sesame Street");
			address1.setZipCode("10013");
			address1.setCity("New York");
			em.persist(address1);
			
			Address address2 = new Address();
			address2.setNumber("742");
			address2.setStreet("Evergreen Terrace");
			address2.setZipCode("65619");
			address2.setCity("Springfield");
			em.persist(address2);
			
			Address address3 = new Address(
					"43", 
					"Cherry Street", 
					"22101", 
					"Langley Falls");
			em.persist(address3);
					
			
			//PETSTORES
			PetStore petStore1 = new PetStore();
			petStore1.setName("Poisson-Chat");
			petStore1.setManagerName("Annie Mallerie");
			petStore1.setAddress(address1);
			em.persist(petStore1);
			
			PetStore petStore2 = new PetStore();
			petStore2.setName("Les Moustaches");
			petStore2.setManagerName("Sebastian Gora");
			petStore2.setAddress(address2);
			em.persist(petStore2);
			
			PetStore petStore3 = new PetStore(
					"Animalerie", 
					"Jonathan Guille",
					address3);
			em.persist(petStore3);
	
			
			//CATS
			Cat cat1 = new Cat();
			cat1.setBirth(new Date(119, 4, 12));
			cat1.setColor("Brown");
			cat1.setChipId("926Y72P409PS6152R94T");
			cat1.setPetStore(petStore2);
			em.persist(cat1);
			
			Cat cat2 = new Cat();		
			cat2.setBirth(new Date(118, 6, 29));
			cat2.setColor("White");
			cat2.setChipId("PJ90UI36A68I10PE17K3");
			cat2.setPetStore(petStore3);
			em.persist(cat2);
			
			Cat cat3 = new Cat(
					new Date(121, 11, 6), 
					"Black and brown", 
					"M0K176U4VB90143D72O0",
					petStore1);
			em.persist(cat3);
			
		
			//FISHS
			Fish fish1 = new Fish();
			fish1.setBirth(new Date(121, 3, 12));
			fish1.setColor("White and red");
			fish1.setPetStore(petStore1);
			fish1.setLivingEnv(FishLivEnv.FRESH_WATER);
			em.persist(fish1);
			
			Fish fish2 = new Fish();
			fish2.setBirth(new Date(119, 1, 21));
			fish2.setColor("Gray");
			fish2.setPetStore(petStore3);
			fish2.setLivingEnv(FishLivEnv.SEA_WATER);
			em.persist(fish2);
			
			Fish fish3 = new Fish(
					new Date(120, 4, 1), 
					"Blue", 
					petStore1,
					FishLivEnv.FRESH_WATER);
			em.persist(fish3);
			
			
			
			//PRODUCTS
			Product product1 = new Product();
			product1.setCode("312CLC");
			product1.setLabel("Cat Litter");
			product1.setType(ProdType.ACCESSORY);
			product1.setPrice(39.99);
			product1.addPetStore(petStore3);
			product1.addPetStore(petStore2);
			em.persist(product1);
			
			Product product2 = new Product();
			product2.setCode("277AFF");
			product2.setLabel("Aquarium Filter");
			product2.setType(ProdType.CLEANING);
			product2.setPrice(74.99);
			product2.addPetStore(petStore1);
			em.persist(product2);
			
			Product product3 = new Product();
			product3.setCode("934CKC");
			product3.setLabel("Cat Kibble");
			product3.setType(ProdType.FOOD);
			product3.setPrice(17.99);

			em.persist(product3);
			
			petStore1.addProduct(product3);
			em.persist(petStore1);
			petStore2.addProduct(product2);
			petStore2.addProduct(product1);
			em.persist(petStore2);
			petStore3.addProduct(product3);
			petStore3.addProduct(product1);
			em.persist(petStore3);
			
			et.commit();
			
			
			//Requête d'extraction des animaux d'une animalerie en fonction de son ID
			Query query = em.createQuery("SELECT a FROM Animal a JOIN a.petStore p WHERE p.id = 1");
			List<Animal> result = query.getResultList();
			
			for(Animal animals : result) {
				System.out.println(animals);
			}
			
		} finally {
			if (em != null)
				em.close();
			if (emf != null) 
				emf.close();
		}
	}
}