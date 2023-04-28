package kim.jerok.practice_spring_11.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardReqDto {
    private String title;
    private String content;
}
