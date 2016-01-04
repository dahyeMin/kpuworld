package makeit.account.security;

import makeit.account.entity.Account;
import makeit.account.entity.AccountRepository;
import makeit.common.KpuworldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by jinhyung on 2015. 12. 3..
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String accountEmail) throws UsernameNotFoundException {

        Account account = accountRepository.findOneByEmail(accountEmail);

        if (account == null) {
            throw new KpuworldException("해당하는 ID의 사용자를 찾을 수 없습니다");
        }

        return new UserDetail(account);
    }
}
