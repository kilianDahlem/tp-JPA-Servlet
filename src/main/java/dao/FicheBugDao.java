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

public class FicheBugDao {
    private static final ThreadLocal<FicheBugDao> threadLocal;

    static {
        threadLocal = new ThreadLocal<FicheBugDao>();
    }
    public static List<FicheBug> getAllFicheBugFromDatabase(){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        int nbFicheBug = manager.createQuery("Select a From FicheBug a", FicheBug.class).getResultList().size();
        System.out.println(nbFicheBug);
        List<FicheBug> fiches = manager.createQuery("Select a From FicheBug a", FicheBug.class).getResultList();
        manager.close();
        return fiches;
    }

    public static FicheBug getFicheBugFromDatabase(int id){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        CriteriaBuilder cb=manager.getCriteriaBuilder();
        AbstractQuery<FicheBug> cq=cb.createQuery(FicheBug.class);
        Root<FicheBug> ficheBug=cq.from(FicheBug.class);
        cq.where(cb.equal(ficheBug.get("id"), id));

        CriteriaQuery<FicheBug> select1 = ((CriteriaQuery<FicheBug>) cq).select(ficheBug);
        TypedQuery<FicheBug> tq1 = manager.createQuery(select1);
        FicheBug resultList = tq1.getSingleResult();

        manager.close();

        return resultList;
    }
    public static void createBug(FicheBug bug){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(bug);
        tx.commit();
        manager.close();
    }
}
