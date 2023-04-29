package kim.jerok.practice_spring_11.controller;

import kim.jerok.practice_spring_11.dto.UserRespDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest  // Filter, DispatcherServlet, Controller, MockMvc를 IoC 컨테이너에 로드한다. (웹 계층 관련된 모든 객체)
public class UserControllerTest {

    @Autowired  // DI
    private MockMvc mockMvc;

    @Test  // @Test 를 붙이면 해당 메서드를 테스트할 수 있다.
    public void addUser_test() throws Exception {  // test 메서드는 파라미터를 전달받을 수 없다.
        // given (파라미터로 요청되는 데이터를 임의로 준비한다)
        String requestBody = "username=jerok&password=1234&tel=01012345678";  // x-www-form-urlencoded

        // when (본코드 테스트를 수행한다)
        MockHttpServletRequestBuilder builders = post("/api/users")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResultActions actions = mockMvc.perform(builders);

        // then (본코드 테스트 결과를 검증한다)
        ResultMatcher isCreated = status().isCreated();
        actions.andExpect(isCreated);

        ResultMatcher location = header().string("Location", "/api/users/1");
        actions.andExpect(location);
    }

    @Test
    public void getUser_test() throws Exception {
        // given
        int id = 1;
        
        // when
        ResultActions actions = mockMvc.perform(get("/api/users/"+id));

        // String responseBody = actions.andReturn().getResponse().getContentAsString();
        // System.out.println("테스트 : " + responseBody);

        // 방법 1 (JSON -> 자바 객체로 변경해서 검증한다)
        // ObjectMapper om = new ObjectMapper();
        // UserRespDto userRespDto = om.readValue(responseBody, UserRespDto.class);
        // Assertions.assertThat(userRespDto.getUsername()).isEqualTo("jerok");

        // 방법 2 (JSON 자체를 검증한다 - 추천)
        
        // then
        actions.andExpect(jsonPath("$.id").value("1"));
        actions.andExpect(jsonPath("$.username").value("jerok"));
        actions.andExpect(jsonPath("$.tel").value("01012345678"));
        actions.andExpect(status().isOk());
    }

    @Test
    public void detail_test() throws Exception {
        // given
        int id = 1;

        // when
        MockHttpServletRequestBuilder builders = get("/users/" + id);
        ResultActions actions = mockMvc.perform(builders);

        // then
        ResultMatcher isOk = status().isOk();
        actions.andExpect(isOk);

        UserRespDto userRespDto = (UserRespDto) actions.andReturn().getModelAndView().getModel().get("user");
        assertThat(userRespDto.getId()).isEqualTo(1);
        assertThat(userRespDto.getUsername()).isEqualTo("jerok");
        assertThat(userRespDto.getTel()).isEqualTo("01012345678");        
    }

}
