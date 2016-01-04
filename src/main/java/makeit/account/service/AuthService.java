package makeit.account.service;

import lombok.extern.slf4j.Slf4j;
import makeit.account.entity.Account;
import makeit.account.entity.AccountRepository;
import makeit.account.security.UserDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 계정 인증 서비스
 * Created by jinhyung on 2016. 1. 4..
 */
@Service
@Slf4j
public class AuthService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    HttpSession httpSession;

    public Account loginWithUuid(String uuid) {
        log.info("uuid = {}", uuid);

        Account account = accountRepository.findOneByUuid(uuid);


        log.info("name = {}", account.getName());

        injectRole(account);

        return account;

    }

    private void injectRole(Account account) {
        UserDetail userDetail = new UserDetail(account);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDetail, userDetail.getPassword(), userDetail.getAuthorities()));

        httpSession.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    }
}
