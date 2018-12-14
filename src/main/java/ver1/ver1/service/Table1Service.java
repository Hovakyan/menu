package ver1.ver1.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import ver1.ver1.entity.Table1;
import ver1.ver1.entity.Table2;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.entity.Userpass;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Table1Service {

    Table1 save(Table1 user);

    Optional<Table1> findByName(String name);
    Optional<Table1>getAllByName(String name);
    Optional<Table1>findById(Integer id);
    Optional<Table1>getById(Integer id);
    List<Table1> findAll();
    Optional<Table1>queryById(Integer id);
    Optional<Table1>queryByName(String name);

    public void deleteById(Integer id);

    public void Add(UserRegistrpost userRegistrpost,Map<String, Object> map);

    public void remuve(UserRegistrpost userRegistrpost,Map<String, Object> map);

    public void  update(UserRegistrpost userRegistrpost,Map<String, Object> map);

    public void total(Map<String, Object> map);
}
