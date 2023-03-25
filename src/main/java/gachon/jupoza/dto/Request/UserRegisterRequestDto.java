package gachon.jupoza.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class UserRegisterRequestDto {
    String userId;
    String userPassword;
    String userEmail;
    String userNickname;

    public static UserRegisterRequestDto of(String userId, String userPassword, String userEmail, String userNickName) {
        return new UserRegisterRequestDto(userId,userPassword,userEmail,userNickName);
    }
}
