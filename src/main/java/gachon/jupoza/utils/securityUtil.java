package gachon.jupoza.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

// API 호출 시 user의 정보가 헤더에 담겨져 올떄 , 어던 멤버가 API를 요청했는지 조회하는 코드
public class securityUtil {
    public static String getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }
        return authentication.getName();
    }
}
