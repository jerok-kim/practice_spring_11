package kim.jerok.practice_spring_11.controller;

import kim.jerok.practice_spring_11.dto.BoardRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * prefix = /resources/templates
 * suffix = .mustache
 */
@Controller  // ViewResolver가 발동
public class ResponseController {

    @GetMapping("/resp/v1")
    public String respV1() {
        return "home";  // 리턴시 발동!!
    }

    // WAS -> Scope (application, session, request, pageContext)
    @GetMapping("/resp/v2")
    public String respV2(Model model) {
        model.addAttribute("title", "제목1");
        return "main";
    }

    @GetMapping("/resp/v3")
    public @ResponseBody String respV3() {  // 버퍼
        return "<h1>text/html 응답</h1>";
    }

    @GetMapping("/resp/v4")
    public @ResponseBody BoardRespDto respV4() {  // 버퍼 + Jackson(Gson)
        return new BoardRespDto(1, "제목1", "내용1");
    }

    // @Controller -> 파일을 리턴
    // ResponseEntity 가 리턴타입에 붙으면 자동으로 @ResponseBody가 발동!!
    // 상태코드 리턴 : 200
    @GetMapping("/resp/v5")
    public ResponseEntity<Void> respV5() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/resp/v6")
    public ResponseEntity<String> respV6() {
        return new ResponseEntity<>("hello", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/resp/v7")
    public @ResponseBody String respV7(HttpServletResponse response) {
        response.setStatus(300);
        return "hello";
    }

    @GetMapping("/resp/v8")
    public ResponseEntity<?> respV7(@RequestParam(defaultValue = "1") String value) {
        if (value.equals("1")) {
            return new ResponseEntity<>("hello", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(1, HttpStatus.OK);
        }
    }

    @GetMapping("/resp/v9")
    public String respV9(HttpSession session) {
        session.setAttribute("title", "제목1");
        return "redirect:/resp/v1";  // ViewResolver 타야하는데!! redirect:
    }

}
