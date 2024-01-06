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

            Member member = new Member();

            member.setUsername("Hello");

            em.persist(member);

            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());

            Member refMember = em.getReference(Member.class, member.getId());
            System.out.println("refMember = " + refMember.getClass());

//            em.detach(refMember); // 영속성 컨텍스트 관리 안함
            //영속성 컨텍스트가 지워지면 더이상 가져올 수 없음
            refMember.getUsername(); // org.hibernate.LazyInitializationException: could not initialize proxy [hellojpa.Member#1] - no Session

            System.out.println("refMember = " + refMember.getUsername());

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            Hibernate.initialize(refMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
        //System.out.println("HI");
    }


}
