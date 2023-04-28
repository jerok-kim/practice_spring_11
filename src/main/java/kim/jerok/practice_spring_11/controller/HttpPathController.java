package kim.jerok.practice_spring_11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpPathController {

    /**
     * QueryString, PathVariable (where절에 줄 데이터 = 구체적인 요청을 하는 데이터)
     * SELECT * FROM user WHERE email = 'jerok.kim@gmail.com';
     * SELECT * FROM user WHERE id = 1;
     */
    // http://localhost:8080/user?email=jerok.kim@gmail.com
    // http://localhost:8080/user/1
    @GetMapping("/data/path/v1/{id}")
    public String pathV1(@PathVariable(value = "id") int id) {
        return "받은 값 : " + id;
    }

}
