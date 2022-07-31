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
            /*//생성
            Member member = new Member();
            member.setId(3L);
            member.setName("HelloC");

            em.persist(member);*/

            /*//조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() : " + findMember.getId());
            System.out.println("findMember.getName() : " + findMember.getName());*/

            /*//수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

            //JPQL
            List<Member> members = em.createQuery("SELECT m FROM Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : members) {
                System.out.println("member : " + member.getName() );
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
