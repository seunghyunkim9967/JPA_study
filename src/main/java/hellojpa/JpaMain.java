package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            List<Member> result = em.createQuery("select m from Member as m where m.name = 'HelloB'", Member.class)
////                    .setFirstResult(5)
////                    .setMaxResults(8)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
////            Member findMember = em.find(Member.class, 1L);
////            System.out.println("findMember.id = " + findMember.getId());
//            //em.persist(member);
////            findMember.setName("HelloJPA");
//            tx.commit();

            //영속
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("findMember = " + findMember1.getId());
//            System.out.println("findMember = " + findMember2.getId());
//            Member member = em.find(Member.class,150L);
//            member.setName("AAAAA");
////            Member member = new Member(200L,"member200");
////            em.persist(member);
//            em.clear();
//            Member member2 = em.find(Member.class,150L);
//            System.out.println("======================" + member2.getId());
            Member member = new Member();
            member.setUsername("C");
            System.out.println("===============");
            em.persist(member);
            System.out.println("===============");
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
