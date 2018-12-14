package ver1.ver1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.entity.Userpass;
import ver1.ver1.rapository.UserpassRepository;
import ver1.ver1.service.UserpassService;

import java.util.Map;
import java.util.Optional;
@Service
public class UserpassServiceimpl implements UserpassService {

    @Autowired
    UserpassRepository userpassRepository;

    @Autowired
    UserpassService userpassService;

    @Override
    public Userpass save(Userpass user) {
        return userpassRepository.save(user);
    }

    @Override
    public Optional<Userpass> findByLogin(String login) {
        return userpassRepository.findByLogin(login);
    }

    @Override
    public Optional<Userpass> findByLoginAndPassword(String login, String password) {
        return userpassRepository.findByLoginAndPassword(login,password);
    }

    @Override
    public Optional<Userpass> getByLoginAndPassword(String login, String password) {
        return userpassRepository.getByLoginAndPassword(login,password);
    }

    @Override
    public void Add(UserRegistrpost userRegistrpost, Map<String, Object> map) {
        Userpass userpass = new Userpass();
        if (!userpassService.findByLoginAndPassword(userRegistrpost.getLogin(),
          userRegistrpost.getPassword()).isPresent()){
          userpass.setLogin(userRegistrpost.getLogin());
          userpass.setPassword(userRegistrpost.getPassword());
          userpassService.save(userpass);
          map.put("success",userRegistrpost.getLogin());
      }else {
          map.put("login and password is already have",null);
      }

    }
}
