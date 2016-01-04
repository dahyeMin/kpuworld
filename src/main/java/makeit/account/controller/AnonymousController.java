package makeit.account.controller;

import makeit.account.entity.Account;
import makeit.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinhyung on 2015. 12. 10..
 */
@RestController
public class AnonymousController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "facebook.do", method = RequestMethod.POST)
    public Account facebook(String token, String uuid) {
        return accountService.facebook(token, uuid);
    }

    /**
     * 익명 푸시등록
     * @param uuid
     * @param push
     * @return
     */
    @RequestMapping(value = "regi.do", method = RequestMethod.POST)
    public Account setanonymous(String uuid, String push) {

        return accountService.anonymous(uuid, push);

    }

}
