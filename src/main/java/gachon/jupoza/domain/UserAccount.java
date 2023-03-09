package gachon.jupoza.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends AuditingFields{



    @Id
    @Column(length = 50)
    private String UserId;

    @Setter @Column(nullable = false)
    private String UserPassword;

    @Setter @Column(length = 100)
    private String email;

    @Setter @Column(length = 100)
    private String nickName;

    @Setter @Column(length = 100)
    private String memo;

    protected UserAccount() {
    }

    public UserAccount(String userId, String user_password, String email, String nickName, String memo) {
        this.UserId = userId;
        this.UserPassword = user_password;
        this.email = email;
        this.nickName = nickName;
        this.memo = memo;
    }

    public static UserAccount of(String user_id, String user_password, String email, String nickName, String memo)
    {
        return new UserAccount(user_id, user_password, email, nickName, memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount)) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(UserId, that.UserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId);
    }
}
