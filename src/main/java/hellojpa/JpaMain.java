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
//            JPQL 문법
//            엔티티와 속성은 대소문자 구분 O (Member, age)
//            JPQL 키워드는 구분 X (SELECT, FROM ,WHERE)
//            엔티티 이름 사용 (테이블이름 X)
//            별칭 필수(m) (as 생략가능)
//
//            -페치 조인 (fetch join)
//            SQL 조인 종류 X, JPQL 성능 최적화 기능, 연관된 엔티티나 컬렉션 SQL 한 번에 함께 조회
//
//            페치조인 DISTINCT (JPQL)
//                    SQL DISTINCT + 엔티티 중복 제거
//
//            페치 조인 특징과 한계
//            - 페치 조인 대상 별칭 줄 수 없다. (하이버네이트 가능하지만 사용X)
//            - 둘 이상의 컬렉션은 페치조인 안됨
//            - 컬렉션 페이징 API 사용 불가(일대일,다대일 단일 값 연관 필드 페치 조인 페이징 가능, 하이버네이트는 경고 로그를 남기고 메모리에서 페이징(매우 위험 대상 테이블을 모두 조회 후에 페이징 처리를 하게됨) )
//            - 연관된 엔티티들을 SQL 한 번으로 조회(성능 최적화)
//            - 엔티티에 적용하는 글로벌 로딩 전략보다 우선함(@OTM(fetch = LAZY) // 글로벌 로딩 전략, 실무에서 글로벌 전략은 지연로딩, 최적화 = 페치 조인 적용)

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
