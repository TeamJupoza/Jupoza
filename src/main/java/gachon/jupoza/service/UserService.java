package gachon.jupoza.service;


import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.dto.Jwt.TokenInfo;
import gachon.jupoza.dto.Request.UserRegisterRequestDto;
import gachon.jupoza.jwt.JwtTokenProvider;
import gachon.jupoza.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserAccountRepository userAccountRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenInfo login(String id, String password)
    {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이떄 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id,password);

        // 2. 실제 검증 ( 사용자 비밀번호 체크) 이 부분이 이루어지는 부분
        // authenticate 메서드가 실행될 떄 CustomUSerDetailsService 에서 만든 loadUserByname 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 jwt 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }

    @Transactional
    public void register(UserRegisterRequestDto userRegisterRequestDto)
    {
        UserAccount userAccount = new UserAccount
                (
                        userRegisterRequestDto.getUserId(),
                        "{noop}"+userRegisterRequestDto.getUserPassword(),
                        userRegisterRequestDto.getUserEmail(),
                        userRegisterRequestDto.getUserNickname(),
                        List.of("USER")
                );


        userAccountRepository.save(userAccount);
    }




}
