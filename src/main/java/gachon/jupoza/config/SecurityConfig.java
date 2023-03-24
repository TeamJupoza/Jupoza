package gachon.jupoza.config;

import gachon.jupoza.jwt.JwtAuthenticationFilter;
import gachon.jupoza.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                // rest api 이므로 basic auth 및 csrf 보안을 사용하지 않는다
                .httpBasic().disable()
                .csrf().disable()
                // Jwt를 사용하기 떄문에 세션은 사용하지않는다.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 해당 api에 대해 모든 요청을 허용한다.
//                .antMatchers("/myportfolio").authenticated()
//                .antMatchers("/articleform").authenticated()
                .anyRequest().permitAll()
                .and()
                // jwt 인증을 위하여 직접 구현한 필터를 usernamepasswordAuthenticationFilter 전에 실행하겠다는 의미
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Jwt 를 사용하기 위해 기본적으로 Password ewncoder 가 필요한데 여기서는 Bycrypt encoder 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}



