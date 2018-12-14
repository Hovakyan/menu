package ver1.ver1.service;

import org.springframework.web.bind.annotation.RequestBody;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.entity.Userpass;

import java.util.Map;
import java.util.Optional;

public interface UserpassService {

    Userpass save(Userpass user);
    Optional<Userpass> findByLogin(String login);
    Optional<Userpass> findByLoginAndPassword(String login,String password);
    Optional<Userpass> getByLoginAndPassword(String login,String password);
public void Add(UserRegistrpost userRegistrpost,Map<String, Object> map);

}
