package gachon.jupoza.service;

import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUSerDetailsService  implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountRepository.findByUserId(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));

    }

    // 해당하는 user의 데이터가 존재한다면 userDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(UserAccount userAccount)
    {
        return User.builder()
                .username(userAccount.getUsername())
                .password(userAccount.getPassword())
                .roles(userAccount.getRoles().toArray(new String[0]))
                .build();

    }
}
