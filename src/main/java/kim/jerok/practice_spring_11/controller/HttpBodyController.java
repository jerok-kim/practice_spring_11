package kim.jerok.practice_spring_11.controller;

import kim.jerok.practice_spring_11.dto.BoardReqDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @RestController
 * -> MessageConverter
 * -> response.getWriter().println();
 * 
 * @Controller
 * -> ViewResolver
 * -> request.setAttribute();
 * -> request.getRequestDispatcher();
 */
@RestController
public class HttpBodyController {

    /**
     * host = localhost:8080
     * endpoint = /data/body/v1
     * method = post
     * QueryString = title (String)
     * Body - x-www-form-urlencoded = title (String)
     */
    @PostMapping("/data/body/v1")
    public String bodyV1(@RequestParam("title") String title) {
        return "받은 값 : " + title;
    }

    @PostMapping("/data/body/v2")
    public String bodyV2(@RequestParam("title") String title, @RequestParam("content") String content) {
        return "받은 값 : " + title + ", " + content;
    }

    // req.getParameter() 안함
    // req.getReader()
    // Jackson 발동
    // String -> Jackson 발동 안함
    @PostMapping("/data/body/v3")
    public String bodyV3(@RequestBody String boardReqDto) throws IOException {  // x-www-form-urlencoded -> 전략변경
        // 버퍼 발동
        // Gson(Jackson) 발동안하면 됨
        // return "받은 값 : " + boardReqDto.getTitle() + ", " + boardReqDto.getContent();
        return "받은 값 : " + boardReqDto;
    }

}
