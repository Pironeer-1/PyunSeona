package com.pironeer.week2_1.member.repository;

import com.pironeer.week2_1.member.entity.Member;
import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {

    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();

    // 저장 메서드
    public Member save(Member member) {
        if (member.getMemberId() == null) {
            Long id = memberIdxGenerator.incrementAndGet();
            member.setId(id);
            memberMap.put(id, member);
            return member;
        } else {
            memberMap.replace(member.getId(), member);
            return member;
        }
    }

    // 1) id로 Member 조회하기
    public Optional<Member> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(memberMap.get(id));
    }

    // 2) memberId로 Member 조회하기
    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();
    }

    // 3) memberId로 Member가 존재하는지 검사하기
    public Boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }
}
