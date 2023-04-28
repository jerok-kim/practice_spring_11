package kim.jerok.practice_spring_11.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespDto {

    private int id;  // 리플렉션으로 찾음 (머스태치 - private 변수에도 접근가능)
    private String username;
    private String tel;

    public UserRespDto(int id, String username, String tel) {
        this.id = id;
        this.username = username;
        this.tel = tel;
    }

}
