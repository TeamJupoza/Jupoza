package gachon.jupoza.controller;

import gachon.jupoza.dto.Jwt.TokenInfo;
import gachon.jupoza.dto.Request.UserLoginRequestDto;
import gachon.jupoza.dto.Request.UserRegisterRequestDto;
import gachon.jupoza.service.UserService;
import gachon.jupoza.utils.securityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody UserLoginRequestDto userLoginRequestDto)
    {
        return userService.login(userLoginRequestDto.getUserId(),userLoginRequestDto.getUserPassword());
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto)
    {
        userService.register(userRegisterRequestDto);
        Map<String,Object> result = new HashMap<>();
        result.put("result","success");

        ResponseEntity<Map<String,Object>> responseEntity = new ResponseEntity<>(result,HttpStatus.OK);

        return responseEntity;


    }


    // 현재 유저아이디와 토큰이 맞는지 검증
    @GetMapping("/validation/{userId}")
    public ResponseEntity<Map<String,Object>> register(@PathVariable String userId) {

        Map<String, Object> result = new HashMap<>();

        String currentMemberId = securityUtil.getCurrentMemberId();

        log.info("input userId : {}", userId);
        log.info("input currentMemberId : {}", currentMemberId);



        if (userId.equals(currentMemberId))
        {
            log.info("성공");
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else
        {
            log.info("실패");
            result.put("result", "fail");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
