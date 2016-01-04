package makeit.util;

import makeit.common.KpuWorldConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jinhyung on 2015. 12. 12..
 */
@RestController
public class Shuttle {

    @RequestMapping(value = "shuttle", method = RequestMethod.GET)
    public Map shuttle() {

        // 정왕역 출발 (등교)
        // 77 수시운행 88도착버스 탑승, 99운행안함
        List toSchool = new ArrayList<>();
        int[] toSchool8 = {42, 54};
        int[] toSchool9 = {10, 15, 31, 45};
        int[] toSchool10 = {3, 15, 29, 48};
        int[] toSchool11 = {3, 21, 40};
        int[] toSchool12 = {10, 36, 54};
        int[] toSchool13 = {15, 25, 53};
        int[] toSchool14 = {6, 28, 56};
        int[] toSchool15 = {19, 44};
        int[] toSchool16 = {7, 17, 32, 47};
        int[] toSchool17 = {5};
        int[] toSchool18 = {88};
        int[] toSchool19 = {88};
        int[] toSchool20 = {88};
        int[] toSchool21 = {99};
        int[] toSchool22 = {99};

        // 학교 출발 ( 하교)
        List toStation = new ArrayList<>();
        int[] toStation8 = {88};
        int[] toStation9 = {88};
        int[] toStation10 = {5, 19, 38, 53};
        int[] toStation11 = {11, 30};
        int[] toStation12 = {0, 26, 44};
        int[] toStation13 = {5, 15, 43, 56};
        int[] toStation14 = {18, 46};
        int[] toStation15 = {9, 34, 57};
        int[] toStation16 = {7, 22, 37, 51};
        int[] toStation17 = {12, 40};
        int[] toStation18 = {0, 15, 41};
        int[] toStation19 = {0, 13, 29, 46};
        int[] toStation20 = {0};
        int[] toStation21 = {99};
        int[] toStation22 = {99};

        toSchool.add(toSchool8);
        toSchool.add(toSchool9);
        toSchool.add(toSchool10);
        toSchool.add(toSchool11);
        toSchool.add(toSchool12);
        toSchool.add(toSchool13);
        toSchool.add(toSchool14);
        toSchool.add(toSchool15);
        toSchool.add(toSchool16);
        toSchool.add(toSchool17);
        toSchool.add(toSchool18);
        toSchool.add(toSchool19);
        toSchool.add(toSchool20);
        toSchool.add(toSchool21);
        toSchool.add(toSchool22);

        toStation.add(toStation8);
        toStation.add(toStation9);
        toStation.add(toStation10);
        toStation.add(toStation11);
        toStation.add(toStation12);
        toStation.add(toStation13);
        toStation.add(toStation14);
        toStation.add(toStation15);
        toStation.add(toStation16);
        toStation.add(toStation17);
        toStation.add(toStation18);
        toStation.add(toStation19);
        toStation.add(toStation20);
        toStation.add(toStation21);
        toStation.add(toStation22);

        Map infoMap = new HashMap<>();
        infoMap.put("toSchoolInfo","8-20");
        infoMap.put("toStationInfo","8-20");
        infoMap.put("77is","Frequently");
        infoMap.put("88is","ArrivalBus");
        infoMap.put("99is","NotService");

        Map map = new HashMap<>();
        map.put("toSchool", toSchool);
        map.put("toStation", toStation);
        map.put("info", infoMap);
        map.put("updateDate", KpuWorldConstants.SHUTTLE_DATE);

        return map;
    }
}
