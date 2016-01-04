package makeit.account.security;

import makeit.account.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jinhyung on 2015. 12. 3..
 */
public class UserDetail extends User {


    public UserDetail(Account account) {
        super(account.getEmail(), account.getPassword(), authorities(account));

    }

    private static Collection<? extends GrantedAuthority> authorities(Account account) {
        List<GrantedAuthority> authorityList = new ArrayList<>();

        String role = account.getRole();
        if (role.equals("ROLE_ADMIN")) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorityList;
    }


}
