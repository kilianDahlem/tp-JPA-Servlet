package dao;

import jpa.EntityManagerHelper;
import jpa.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MembreDao {

    private static final ThreadLocal<MembreDao> threadLocal;

    static {
        threadLocal = new ThreadLocal<MembreDao>();
    }
    public static List<Membre> getAllMembresFromDatabase(){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        int nbMembres = manager.createQuery("Select a From Membre a", Membre.class).getResultList().size();
        System.out.println(nbMembres);
        List<Membre> membres = manager.createQuery("Select a From Membre a", Membre.class).getResultList();
        manager.close();
        return membres;
    }

    public static Membre getMembreFromDatabase(int id){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        CriteriaBuilder cb=manager.getCriteriaBuilder();
        AbstractQuery<Membre> cq=cb.createQuery(Membre.class);
        Root<Membre> membre=cq.from(Membre.class);
        cq.where(cb.equal(membre.get("id"), id));

        CriteriaQuery<Membre> select1 = ((CriteriaQuery<Membre>) cq).select(membre);
        TypedQuery<Membre> tq1 = manager.createQuery(select1);
        Membre resultList = tq1.getSingleResult();

        manager.close();

        return resultList;
    }
    public static void createMembre(Membre membre){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(membre);
        tx.commit();
        manager.close();
    }
}


