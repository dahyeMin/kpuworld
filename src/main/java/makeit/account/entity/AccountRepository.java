package makeit.account.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhyung on 2015. 12. 10..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByFbid(String fbid);

    Account findOneByEmail(String email);

    Account findOneByUuid(String uuid);
}
