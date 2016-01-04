package makeit.account.service;

import makeit.account.entity.Account;
import makeit.account.entity.AccountDto;
import makeit.account.entity.AccountRepository;
import makeit.account.MyFacebookTemplate;
import makeit.account.security.UserDetail;
import makeit.common.KpuworldException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 10..
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Deprecated
    public Account joinProcess(String token, String uuid) {
        MyFacebookTemplate myFacebookTemplate = new MyFacebookTemplate(token);
        User userProfile = myFacebookTemplate.getUserProfile();

        Account account = accountRepository.findOneByUuid(uuid);

        account.setName(userProfile.getName());
        account.setSexual(userProfile.getGender());
        account.setJoinDate(new Date());
        account.setRole("ROLE_USER");
        account.setFbid(userProfile.getId());
        account.setUuid(uuid);

        account = accountRepository.save(account);


        return account;
    }

    @Deprecated
    public Account loginProcess(String token) {
        MyFacebookTemplate myFacebookTemplate = new MyFacebookTemplate(token);
        User userProfile = myFacebookTemplate.getUserProfile();

        Account account = accountRepository.findOneByFbid(userProfile.getId());


        if(account == null) {
            throw new KpuworldException("cannot find facebook user");
        }

        UserDetail userDetail = new UserDetail(account);

        SecurityContextHolder
                .getContext()
                .setAuthentication(
                        new UsernamePasswordAuthenticationToken(userDetail, null, null));

        return account;
    }

    public Account anonymous(String uuid, String key) {

        Account account = accountRepository.findOneByUuid(uuid);

        if(account == null) {
            account = new Account();
            account.setUuid(uuid);
            account.setJoinDate(new Date());
            account.setPhone("android");
            account.setRole("ROLE_NONE");
            account.setPassword("none");
            account.setLastLoginDate(new Date());
        }
        account.setPush(key);
        account.setLastLoginDate(new Date());

        account = accountRepository.save(account);

        return account;
    }

    /**
     * 페북로그인
     * @param token
     * @param uuid
     * @return
     */
    public Account facebook(String token, String uuid) {
        MyFacebookTemplate myFacebookTemplate = new MyFacebookTemplate(token);
        User userProfile = myFacebookTemplate.getUserProfile();

        Account fbIdAccount = accountRepository.findOneByFbid(userProfile.getId());
        Account uuidAccount = accountRepository.findOneByUuid(uuid);

        Account account = new Account();

        // 페북 아이디가 등록되어있는경우
        if(fbIdAccount != null) {
            // 로그인
            account = fbIdAccount;
        } else {
            //페북 아디가 없는경우
            if(uuidAccount != null) {
                // 로그인 한적이 있는 사용자
                account = uuidAccount;
            } else {
                // 로그인 한적이 없는 사용자
                account.setUuid(uuid);
            }
            account.setName(userProfile.getName());
            account.setSexual(userProfile.getGender());
            account.setJoinDate(new Date());
            account.setRole("ROLE_USER");
            account.setFbid(userProfile.getId());

            account = accountRepository.save(account);
        }

        UserDetail userDetail = new UserDetail(account);

        SecurityContextHolder
                .getContext()
                .setAuthentication(
                        new UsernamePasswordAuthenticationToken(userDetail, null, null));

        return account;
    }

    public Account update(AccountDto.Update update) {
        Account originalAccount = accountRepository.findOneByUuid(update.getUuid());
        Account newAccount = modelMapper.map(update, Account.class);

        int hack = newAccount.getHackBun();
        String name = newAccount.getName();
        String major = newAccount.getMajor();
        String sexual = newAccount.getSexual();
        String email = newAccount.getEmail();


        originalAccount.setHackBun(newAccount.getHackBun());
        originalAccount.setName(newAccount.getName());
        originalAccount.setMajor(newAccount.getMajor());
        originalAccount.setSexual(newAccount.getSexual());
        originalAccount.setEmail(newAccount.getEmail());
        originalAccount.setLastLoginDate(new Date());
        originalAccount = accountRepository.save(originalAccount);

        return originalAccount;
    }
}
