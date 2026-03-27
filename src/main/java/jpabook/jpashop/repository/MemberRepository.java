package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // 회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    // PK로 회원 단건 조회
    public Member findOne (Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 조회 (JPQL)
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 이름으로 회원 조회 (파라미터 바인딩)
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
