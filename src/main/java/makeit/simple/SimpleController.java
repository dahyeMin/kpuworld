package makeit.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
@RestController
@RequestMapping("simple")
public class SimpleController {

    @Autowired
    SimpleRepository simpleRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Simple create(@ModelAttribute Simple simple) {

        simple.setWriteDate(new Date());
        return simpleRepository.save(simple);

    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Simple> list(Pageable pageable) {
        return simpleRepository.findAll(pageable);
    }


}
