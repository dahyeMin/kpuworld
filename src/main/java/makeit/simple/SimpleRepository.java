package makeit.simple;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
public interface SimpleRepository extends JpaRepository<Simple, Long> {
}
