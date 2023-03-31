package dao;

import jpa.EntityManagerHelper;
import jpa.*;

import javax.persistence.*;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {
    private static final ThreadLocal<UserDao> threadLocal;

    static {
        threadLocal = new ThreadLocal<UserDao>();
    }
    public static List<User> getAllUsersFromDatabase(){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        int nbUsers = manager.createQuery("Select a From User a", User.class).getResultList().size();
        System.out.println(nbUsers);
        List<User> users = manager.createQuery("Select a From User a", User.class).getResultList();
        manager.close();
        return users;
    }

    public static User getUserFromDatabase(int id){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        CriteriaBuilder cb=manager.getCriteriaBuilder();
        AbstractQuery<User> cq=cb.createQuery(User.class);
        Root<User> user=cq.from(User.class);
        cq.where(cb.equal(user.get("id"), id));

        CriteriaQuery<User> select1 = ((CriteriaQuery<User>) cq).select(user);
        TypedQuery<User> tq1 = manager.createQuery(select1);
        User resultList = tq1.getSingleResult();

        manager.close();

        return resultList;
    }

    public static void createUser(User user){
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(user);
        tx.commit();
        manager.close();
    }
}
