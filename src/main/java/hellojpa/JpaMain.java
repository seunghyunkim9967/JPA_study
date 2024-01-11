package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        try{
//            --ex1
//            DROP TABLE ALBUM ;
//            DROP TABLE BOOK ;
//            DROP TABLE ITEM ;
//            DROP TABLE MOVIE ;
//            DROP TABLE MEMBER;
//            DROP TABLE ADDRESS ;
//            DROP TABLE ADDRESSENTITY ;
//            DROP TABLE CHILD ;
//            DROP TABLE FAVORIT_FOOD ;
//            DROP TABLE MEMBER;
//            DROP TABLE MY_SEQUENCES ;
//            DROP TABLE PARENT ;
//            DROP TABLE TEAM ;


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }


}
