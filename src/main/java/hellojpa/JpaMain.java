package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*//1차 캐시
            Member findeMember1 = em.find(Member.class, 103L);
            Member findeMember2 = em.find(Member.class, 103L);*/

            /*//영속 엔티티 동일성
            System.out.println("result : " + (findeMember1 == findeMember2));*/

            /*//엔티티 등록 - 트랜잭션을 지원하는 쓰기 지연
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(151L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("-------");*/

            /*//엔티티 수정 - 변경 감지
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZ");*/

            //엔티티 삭제
            Member member = em.find(Member.class, 150L);
            em.remove(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
