package makeit.temp;

import makeit.account.entity.Account;
import makeit.account.entity.AccountRepository;
import makeit.account.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinhyung on 2016. 1. 4..
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Account> UserList(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
    @RequestMapping(value = "prin", method = RequestMethod.GET)
    public UserDetail getDetail(@AuthenticationPrincipal UserDetail userDetail) {
        return userDetail;
    }
}
