package kim.jerok.practice_spring_11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * QueryString = ?x-www-form-urlencoded (주소에 붙는다)
 */
@RestController
public class HttpQueryController {

    // http://localhost:8080/data/query/v1?keyword=jerok
    @GetMapping("/data/query/v1")
    public String queryV1(@RequestParam("keyword") String keyword) {
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v2")
    public String queryV2(@RequestParam(value = "keyword", required = false) String keyword) {
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v3")
    public String queryV3(@RequestParam(value = "keyword", required = false, defaultValue = "Rust") String keyword) {
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v4")
    public String queryV4(String keyword) {
        if (keyword == null) {
            keyword = "default value";
        }
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v5")
    public String queryV5(@RequestParam(defaultValue = "default") String keyword) {
        return "받은 값 : " + keyword;
    }

    // http://localhost:8080/data/query/v6?keyword=jerok&type=text
    @GetMapping("/data/query/v6")
    public String queryV6(String keyword, String type) {
        return "받은 값 : " + keyword + ", " + type;
    }

}
