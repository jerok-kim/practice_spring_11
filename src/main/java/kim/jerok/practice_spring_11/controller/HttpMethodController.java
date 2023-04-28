package kim.jerok.practice_spring_11.controller;

import kim.jerok.practice_spring_11.dto.ExampleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 스프링이 지정해둔 어노테이션이 있는데 8가지 정도 된다. (그 친구들이 new 됨)
 * 어노테이션을 적으면 컨트롤러가 된다. (이유가 궁금하지만, 지금은 단계가 아니다)
 */
@RestController  // Data를 응답하는 컨트롤러 (BufferedWriter)
public class HttpMethodController {

    // http://localhost:8080/req/get
    @GetMapping(value = "/req/get", produces = MediaType.TEXT_HTML_VALUE)
    public String methodGet() {
        return "<h1>get 요청</h1>";  // http body 에 내용!! -> body Content-type : text/html
    }

    @PostMapping("/req/post")
    public String methodPost() {
        return "<h1>post 요청</h1>";
    }

    @PutMapping("/req/put")
    public String methodPut() {
        return "<h1>put 요청</h1>";
    }

    @DeleteMapping("/req/delete")
    public String methodDelete() {
        return "<h1>delete 요청</h1>";
    }

    // @GetMapping("/example")
    // public String example1(@RequestParam("id") String id) {
    //     // 요청 매개 변수로 전달된 데이터를 사용하는 코드
    //     return "example1";
    // }
    //
    // @GetMapping("/example/{id}")
    // public String example2(@PathVariable("id") String id) {
    //     // URL 경로 변수로 전달된 데이터를 사용하는 코드
    //     return "example2";
    // }
    //
    // @PostMapping("/example")
    // public String example3(@RequestBody ExampleDto exampleDto) {
    //     // 요청 본문에 전달된 데이터를 사용하는 코드
    //     return "example3";
    // }
    //
    // @GetMapping("/example")
    // public String example4(HttpServletRequest request) {
    //     // HttpServletRequest 객체를 사용하여 요청 정보를 사용하는 코드
    //     return "example4";
    // }

}
