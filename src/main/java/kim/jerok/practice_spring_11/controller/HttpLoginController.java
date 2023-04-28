package kim.jerok.practice_spring_11.controller;

import kim.jerok.practice_spring_11.dto.LoginReqDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HttpLoginController {

    /**
     * host = localhost:8080
     * endpoint = /login/v1
     * method = post
     * Body LoginReqDto username(String), password(String)
     */
    @PostMapping("/login")
    public String loginV1(@RequestBody LoginReqDto loginReqDto, HttpServletResponse resp) throws IOException {
        String status = "ok";
        resp.setContentType("text/html");
        String mimetype = resp.getContentType();
        if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
            throw new RuntimeException("username이 없습니다");
        }
        if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
            throw new RuntimeException("password가 없습니다");
        }
        return "body : " + status + "\n\n" + "mimetype : " + mimetype;
    }

}
