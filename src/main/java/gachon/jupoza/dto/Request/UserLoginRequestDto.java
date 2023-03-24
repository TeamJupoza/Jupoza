package gachon.jupoza.dto.Request;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String userId;
    private String userPassword;
}
