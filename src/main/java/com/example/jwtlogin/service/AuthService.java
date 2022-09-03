package com.example.jwtlogin.service;

import com.example.jwtlogin.dto.MemberRequestDto;
import com.example.jwtlogin.dto.MemberResponseDto;
import com.example.jwtlogin.dto.TokenDto;
import com.example.jwtlogin.entity.Member;
import com.example.jwtlogin.jwt.TokenProvider;
import com.example.jwtlogin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberResponseDto signup(MemberRequestDto requestDto) {
        if (memberRepository.existsMemberByNickname(requestDto.getNickname())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        if (!requestDto.getConfirmpassword().equals(requestDto.getPassword())) {
            throw new RuntimeException("확인 비밀번호가 같지 않습니다.");
        }
        Member member = requestDto.toMember(passwordEncoder);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    public TokenDto login(MemberRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }

}
