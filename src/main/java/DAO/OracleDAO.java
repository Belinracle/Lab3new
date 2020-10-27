package DAO;

import beans.OneRowBean;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.ArrayList;


@Named("OracleDAO")
@ApplicationScoped
public class OracleDAO implements Serializable {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction transaction;


    public void addPoint(OneRowBean point){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            transaction.begin();
            entityManager.persist(point);
            transaction.commit();
        }
        catch (Exception e) {
            try {
                transaction.rollback();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<OneRowBean> getAllPoints(){
        EntityManager em = entityManagerFactory.createEntityManager();
        return new ArrayList<OneRowBean>(em.createQuery("SELECT p from beans.OneRowBean p").getResultList());
    }
}
