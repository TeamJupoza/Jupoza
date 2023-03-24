package gachon.jupoza.domain;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends AuditingFields implements UserDetails {


    @Id
    @Column(length = 50)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String UserPassword;

    @Setter
    @Column(length = 100)
    private String email;

    @Setter
    @Column(length = 100)
    private String nickName;



    @Setter
    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    protected UserAccount() {
    }

    public UserAccount(String userId, String user_password, String email, String nickName) {
        this.userId = userId;
        this.UserPassword = user_password;
        this.email = email;
        this.nickName = nickName;
    }

    public UserAccount(String userId, String userPassword, String email, String nickName, List<String> roles) {
        this.userId = userId;
        UserPassword = userPassword;
        this.email = email;
        this.nickName = nickName;
        this.roles = roles;
        this.setCreatedAt(LocalDateTime.now());
        this.setCreatedBy(userId);
        this.setModifiedAt(LocalDateTime.now());
        this.setModifiedBy(userId);
    }

    public static UserAccount of(String user_id, String user_password, String email, String nickName) {
        return new UserAccount(user_id, user_password, email, nickName);
    }
    public static UserAccount of(String user_id, String user_password, String email, String nickName, List<String> roles) {
        return new UserAccount(user_id, user_password, email, nickName, roles);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount)) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public String getPassword() {
        return getUserPassword();
    }

    @Override
    public String getUsername() {
        return getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
