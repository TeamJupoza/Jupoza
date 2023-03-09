package gachon.jupoza.dto;

import gachon.jupoza.domain.UserAccount;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link gachon.jupoza.domain.UserAccount} entity
 */
@Data
public class UserAccountDto  {

    private final String UserId;
    private final String UserPassword;
    private final String email;
    private final String nickName;
    private final String memo;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static UserAccountDto of(String userId, String user_password, String email, String nickName, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String  modifiedBy)
    {
        return new UserAccountDto(userId,user_password,email,nickName,memo,createdAt,createdBy,modifiedAt,modifiedBy);
    }

    public static UserAccountDto of(String userId, String user_password, String email, String nickName, String memo)
    {
        return new UserAccountDto(userId,user_password,email,nickName,memo,null,null,null,null);
    }

    public static UserAccountDto from(UserAccount entity)
    {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickName(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity()
    {
        return UserAccount.of(
                UserId,
                UserPassword,
                email,
                nickName,
                memo
        );
    }

}