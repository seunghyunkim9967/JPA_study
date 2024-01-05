package hellojpa;

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


            Member member = new Member();
            member.setCreatedBy(("kim"));
            member.setUsername("user1");
            member.setCreatedDate(LocalDateTime.now());
            em.persist(member);

            em.flush();
            em.clear();

//            Movie findMove = em.find(Movie.class, movie.getId());
//            System.out.println("findMove = " + findMove);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
        //System.out.println("HI");
    }
}
