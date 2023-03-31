package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager m){
		this.manager = m;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			test.createFicheBug();
			test.createFicheFeatureRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listeFicheBugRecorded();
		test.listeFicheFeatureRecorded();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	private void createFicheBug(){
		int numberOfTickets = manager.createQuery("Select a From FicheBug a", FicheBug.class).getResultList().size();
		if(numberOfTickets == 0){
			User user = new User("u1");
			Membre membre = new Membre("m1");
			String sNew = "New";
			String sOpen = "Open";
			String sJava = "Java";
			String sPython = "Python";
			List<String> tag1 = new ArrayList<>();
			List<String> tag2 = new ArrayList<>();
			tag1.add(sNew);
			tag1.add(sJava);
			tag2.add(sOpen);
			tag2.add(sPython);
			manager.persist((user));
			manager.persist((membre));
			manager.persist(new FicheBug("ticket1 - pb", "01/02/2023", user, membre, tag1));
			manager.persist(new FicheBug("ticket2 - anomalie", "01/02/2023", user, membre, tag2));

		}
	}

	private void listeFicheBugRecorded(){
		List<FicheBug> ticketsRecorded = manager.createQuery("Select a From FicheBug a", FicheBug.class).getResultList();
		System.out.println("num of tickets : " + ticketsRecorded.size());
		for (Fiche next : ticketsRecorded){
			System.out.println("next ticket : " + next.getContent());
		}
	}

	private void createFicheFeatureRequest(){
		int numberOfTickets = manager.createQuery("Select a From FicheFeatureRequest a", FicheFeatureRequest.class).getResultList().size();
		if(numberOfTickets == 0){
			User user = new User("u1");
			Membre membre = new Membre("m1");
			String sNew = "New";
			String sOpen = "Open";
			String sJava = "Java";
			String sPython = "Python";
			List<String> tag1 = new ArrayList<>();
			List<String> tag2 = new ArrayList<>();
			tag1.add(sNew);
			tag1.add(sJava);
			tag2.add(sOpen);
			tag2.add(sPython);
			manager.persist((user));
			manager.persist((membre));
			manager.persist(new FicheFeatureRequest("ticket1 - MAJ", "01/02/2023", user, membre, tag1));
			manager.persist(new FicheFeatureRequest("ticket2 - Add sound", "01/02/2023", user, membre, tag2));

		}
	}

	private void listeFicheFeatureRecorded(){
		List<FicheFeatureRequest> ticketsRecorded = manager.createQuery("Select a From FicheFeatureRequest a", FicheFeatureRequest.class).getResultList();
		System.out.println("num of tickets : " + ticketsRecorded.size());
		for (Fiche next : ticketsRecorded){
			System.out.println("next ticket : " + next.getContent());
		}
	}


}