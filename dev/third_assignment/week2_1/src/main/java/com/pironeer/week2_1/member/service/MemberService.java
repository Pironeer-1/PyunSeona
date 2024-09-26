package com.pironeer.week2_1.member.service;

//exception 코드 추가
import com.pironeer.week2_1.global.exception.CustomException;
import com.pironeer.week2_1.global.exception.ErrorCode;

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
        // 아이디 중복 체크
        if (memberRepository.existByMemberId(req.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
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
        Member member = memberRepository.findByMemberId(req.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        // 비밀번호 검증
        if (!member.getPassword().equals(req.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }
        return ResponseService.getSingleResult("Login successful");
    }
}


