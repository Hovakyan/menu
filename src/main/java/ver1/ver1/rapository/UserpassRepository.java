package ver1.ver1.rapository;

import org.springframework.data.jpa.repository.JpaRepository;
import ver1.ver1.entity.Table2;
import ver1.ver1.entity.Userpass;

import java.util.Optional;

public interface UserpassRepository extends JpaRepository<Userpass,Integer> {

    Optional<Userpass> findByLogin(String login);
    Optional<Userpass> findByLoginAndPassword(String login,String password);
    Optional<Userpass> getByLoginAndPassword(String login,String password);

}
