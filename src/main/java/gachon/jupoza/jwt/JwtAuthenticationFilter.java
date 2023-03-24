package gachon.jupoza.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
        JwtAuthenticationFilter
        * 클라이언트 요청시 JWT 인증을 하기 위해서 설치하는 커스텀 필터
        * UsernamePasswordAuthenticationFilter 이전에 실행된다.
        * Username + password를 통한 인증을 Jwt를 통해 수행한다.
*/

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 1. Request Header 에서 jwt 토큰 추출
        String token = resolveToken((HttpServletRequest) request);

        // 2. validateToken 으로 토큰 유효성 검사
        if (token != null && jwtTokenProvider.validateToken(token))
        {
            // 토큰이 유효할 경우 토큰에서 Authentication 객체를 가지고 와서 SecurityContext 에 저장
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    // Request Header 에서 토큰 정보 추출
    private String resolveToken(HttpServletRequest request)
    {
        String bearToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearToken) && bearToken.startsWith("Bearer"))
        {
            return bearToken.substring(7);
        }
        return null;
    }
}
