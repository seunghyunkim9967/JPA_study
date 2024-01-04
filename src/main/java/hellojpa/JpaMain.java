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

//            // 저장
//            Team team = new Team();
//            team.setName("TeamA");
//
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            //연관관계의 주인에만 값 설정
////            member.changeTeam(team);
//            em.persist(member);
//
////            team.addMember(member);
////            team.getMembers().add(member); // 순수 객체 상태를 고려해서 항상 양쪽에 값 설정
//
////            em.flush();
////            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
////            List<Member> members = findTeam.getMembers();
//
////            for (Member m : members) {
////                System.out.println("m = " + m.getUsername());
////            }
//            System.out.println(findTeam);
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
