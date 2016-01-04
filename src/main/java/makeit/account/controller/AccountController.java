package makeit.account.controller;

import makeit.account.entity.Account;
import makeit.account.entity.AccountDto;
import makeit.account.service.AccountService;
import makeit.account.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jinhyung on 2016. 1. 4..
 */
@RequestMapping("account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.PUT)
    public AccountDto.Response updateInfo(@ModelAttribute AccountDto.Update update) {

        Account account = accountService.update(update);

        return modelMapper.map(account, AccountDto.Response.class);
    }

    @RequestMapping(value = "login.kpu", method = RequestMethod.POST)
    public AccountDto.Response login(@RequestParam String uuid) {

        Account account = authService.loginWithUuid(uuid);

        return modelMapper.map(account, AccountDto.Response.class);

    }
}
