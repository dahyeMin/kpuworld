package makeit.temp;

import lombok.extern.slf4j.Slf4j;
import makeit.common.KpuWorldConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinhyung on 2015. 12. 10..
 */
@RestController
@Slf4j
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, String> home() {

        Map<String, String> map = new HashMap<>();
        map.put("version", KpuWorldConstants.APP_VERSION);
        map.put("notice","모바일에서 학사공지나 일반공지가 제대로 안보여서 이 어플을 만들게 되었습니다, " +
                "하다보니 셔틀 위젯도 있으면 좋을꺼 같아서 추가했고요 차후에 쓰시는분들 많으면" +
                "택시카풀이나, 식단표 정보 보여주기 이런것도 만들계획입니다." +
                "자유롭게 이용 해 주세요");
        map.put("shuttle", KpuWorldConstants.SHUTTLE_DATE);

        return map;
    }
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Date timeTest() {
        log.info("time = {}", new Date());
        return new Date();
    }
}
