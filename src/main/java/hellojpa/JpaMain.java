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

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("Hello");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//////            Member findMember = em.find(Member.class, member.getId());
////
////            Member refMember = em.getReference(Member.class, member.getId());
////            System.out.println("refMember = " + refMember.getClass());
////
//////            em.detach(refMember); // 영속성 컨텍스트 관리 안함
////            //영속성 컨텍스트가 지워지면 더이상 가져올 수 없음
////            refMember.getUsername(); // org.hibernate.LazyInitializationException: could not initialize proxy [hellojpa.Member#1] - no Session
////
////            System.out.println("refMember = " + refMember.getUsername());
////
////            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
////
////            Hibernate.initialize(refMember);
////            Member m = em.find(Member.class, member1.getId());
//
////            System.out.println("m = " + m.getTeam().getClass());
//
////            System.out.println("===========");
////            m.getTeam().getName();
////            System.out.println("===========");
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                            .getResultList();

//            Parent parent = new Parent();
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

            Member member = new Member();
            member.setUsername(("member1"));
            member.setHomeAddress(new Address("homecity","street","10"));
//            member.setWorkPeriod(new Period());

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("old1","street","10"));
            member.getAddressHistory().add(new AddressEntity("old2","street","10"));



            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===============  STRAT ===============");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }

//            findMember.getHomeAddress().setCity("newCity"); // 안됨
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(),a.getZipcode()));
//
//            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new Address("old1","street","10"));
//            findMember.getAddressHistory().add(new Address("newCity1","street","10"));



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
