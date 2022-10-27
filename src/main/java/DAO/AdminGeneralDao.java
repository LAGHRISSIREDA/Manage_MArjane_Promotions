package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import model.AdminGeneral;
import utils.JpaService;

import java.util.List;
import java.util.Optional;

public class AdminGeneralDao implements DAO<AdminGeneral> {

    JpaService jpaService = JpaService.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;


    //default constructor && open connection with database

    public AdminGeneralDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }


    @Override
    public Optional<AdminGeneral> findById(long id) {
        return Optional.empty();
    }


    /*
    save a admin
     */

    @Override
    public AdminGeneral save(AdminGeneral adminGeneral) {
        try{
            transaction.begin();
            if(adminGeneral == null){
                em.persist(null);
            }
            em.merge(adminGeneral);
            transaction.commit();
            return adminGeneral;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            jpaService.shutdown();
        }
        return adminGeneral;
    }

    @Override
    public List<AdminGeneral> all() {
        return em.createQuery("SELECT c FROM admingeneral c", AdminGeneral.class).getResultList();
    }

    @Override
    public Boolean update(long id, AdminGeneral adminGeneral) {
        return null;
    }

    @Override
    public Boolean delete(long id) {
        return null;
    }

    public static void main(String[] args) {
        AdminGeneral ad = new AdminGeneral("reda","kamal","dfsf@.com","sdfsdfsd");
        AdminGeneralDao d=new AdminGeneralDao();

    }
}
