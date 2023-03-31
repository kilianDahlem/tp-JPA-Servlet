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

public class FicheFeatureDao {
    private static final ThreadLocal<FicheFeatureDao> threadLocal;

    static {
        threadLocal = new ThreadLocal<FicheFeatureDao>();
    }
    public static List<FicheFeatureRequest> getAllFicheFeatureFromDatabase(){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        int nbFicheFeature = manager.createQuery("Select a From FicheFeatureRequest a", FicheFeatureRequest.class).getResultList().size();
        System.out.println(nbFicheFeature);
        List<FicheFeatureRequest> fiches = manager.createQuery("Select a From FicheFeatureRequest a", FicheFeatureRequest.class).getResultList();
        manager.close();
        return fiches;
    }

    public static FicheFeatureRequest getFicheFeatureFromDatabase(int id){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        CriteriaBuilder cb=manager.getCriteriaBuilder();
        AbstractQuery<FicheFeatureRequest> cq=cb.createQuery(FicheFeatureRequest.class);
        Root<FicheFeatureRequest> ficheFeature=cq.from(FicheFeatureRequest.class);
        cq.where(cb.equal(ficheFeature.get("id"), id));

        CriteriaQuery<FicheFeatureRequest> select1 = ((CriteriaQuery<FicheFeatureRequest>) cq).select(ficheFeature);
        TypedQuery<FicheFeatureRequest> tq1 = manager.createQuery(select1);
        FicheFeatureRequest resultList = tq1.getSingleResult();

        manager.close();

        return resultList;
    }
    public static void createFeature(FicheFeatureRequest featureRequest){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(featureRequest);
        tx.commit();
        manager.close();
    }
}
