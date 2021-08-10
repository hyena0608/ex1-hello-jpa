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

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); //Proxy
            Hibernate.initialize(refMember); //강제 초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));


            //
//            em.detach(refMember);
//            em.close();
//            System.out.println("refMember = " + refMember.getUsername());

            //
//            refMember.getUsername();
//
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass());
//
//            System.out.println("refMember == findMember: " + (refMember == findMember));
            //
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            System.out.println("m1 == m2: " + (m1 instanceof Member));
//            System.out.println("m1 == m2: " + (m2 instanceof Member));

            //
//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("before findMember = " + findMember.getClass()); //프록시 클래스
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());
//            System.out.println("after findMember = " + findMember.getClass()); //프록시 클래스

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());

    }
}
