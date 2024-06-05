package com.sparta.newspeed.controller;

import com.sparta.newspeed.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ReissueController {

    private final JWTUtil jwtUtil;

    public ReissueController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {

        //get refresh token
        String refresh = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //refresh 토큰이 있다면
            if (cookie.getName().equals("refresh")) {

                refresh = cookie.getValue();
            }
        }
        //refresh토큰이 없다면
        if (refresh == null) {

            //refresh토큰 없다는 상태코드
            return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
        }

        //기간 만료
        try {
            jwtUtil.isExpired(refresh);
        } catch (ExpiredJwtException e) {

            //refresh토큰 만료 상태코드
            return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
        }

        // 토큰이 refresh인지 확인 (발급시 페이로드에 명시)
        String category = jwtUtil.getCategory(refresh);

        if (!category.equals("refresh")) {

            //refresh토큰이 아닐경우 상태코드
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        String username = jwtUtil.getUsername(refresh);
        String role = jwtUtil.getRole(refresh);

        //새로운 access토큰 생성
        String newAccess = jwtUtil.createJwt("access", username, role, 600000L);

        //response
        response.setHeader("access", newAccess);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
