package com.pironeer.week2_1.member.service;

import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import com.pironeer.week2_1.global.service.ResponseService;
import com.pironeer.week2_1.member.dto.request.MemberCreateReq;
import com.pironeer.week2_1.member.dto.request.MemberLoginReq;
import com.pironeer.week2_1.member.entity.Member;
import com.pironeer.week2_1.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SingleResult<String> register(MemberCreateReq req) {
        if (memberRepository.existByMemberId(req.memberId())) {
            return ResponseService.getSingleResult("User already exists");
        }

        Member newMember = Member.builder()
                .memberId(req.memberId())
                .password(req.password())
                .name(req.name())
                .build();
        newMember = memberRepository.save(newMember);

        // 성공 메시지 반환하기
        return ResponseService.getSingleResult("Registration successful");
    }

    public SingleResult<String> login(MemberLoginReq req) {
        Member member = memberRepository.findByMemberId(req.memberId()).orElse(null);

        if (member == null) {
            return ResponseService.getSingleResult("User does not exist");
        }

        // 비밀번호 검증하기, 검증되면 로그인 성공 메시지 반환
        if (!member.getPassword().equals(req.password())) {
            return ResponseService.getSingleResult("Wrong password");
        }
        return ResponseService.getSingleResult("Login successful");
    }
}


