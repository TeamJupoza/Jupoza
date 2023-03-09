package gachon.jupoza.dto;

import gachon.jupoza.domain.UserAccount;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link gachon.jupoza.domain.UserAccount} entity
 */
@Data
public class UserAccountDto  {

    private final Long id;
    private final String userId;
    private final String user_password;
    private final String email;
    private final String nickName;
    private final String memo;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static UserAccountDto of(Long id, String userId, String user_password, String email, String nickName, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String  modifiedBy)
    {
        return new UserAccountDto(id,userId,user_password,email,nickName,memo,createdAt,createdBy,modifiedAt,modifiedBy);
    }

    public static UserAccountDto of(Long id, String userId, String user_password, String email, String nickName, String memo)
    {
        return new UserAccountDto(id,userId,user_password,email,nickName,memo,null,null,null,null);
    }

    public static UserAccountDto from(UserAccount entity)
    {
        return new UserAccountDto(
                entity.getId(),
                entity.getUser_id(),
                entity.getUser_password(),
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
                userId,
                user_password,
                email,
                nickName,
                memo
        );
    }

}