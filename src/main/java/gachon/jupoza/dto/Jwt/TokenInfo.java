package gachon.jupoza.dto.Jwt;

// 클라이언트에 토큰을 보내기 위해 DTO 를 생성함

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenInfo {

    private String grantType;  // Bearer 사용
    private String accessToken;
    private String refreshToken;

    public static TokenInfo of(String grantType, String accessToken, String refreshToken) {
        return new TokenInfo(grantType,accessToken,refreshToken);
    }
}
