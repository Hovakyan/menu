package ver1.ver1.service;

import ver1.ver1.entity.Table1;
import ver1.ver1.entity.Table2;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.entity.Userpass;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Table2Servise {

    Table2 save(Table2 user);
    Optional<Table2> findByName(String name);
    Optional<Table2>getAllByName(String name);
    void deleteById(Integer id);
    Optional<Table2>findById(Integer id);
    List<Table2> findAll();
    Optional<Table2>queryById(Integer id);
    Optional<Table2> queryByName(String name);

    public void Add(UserRegistrpost userRegistrpost, Map<String, Object> map);

    public void remuve(UserRegistrpost userRegistrpost,Map<String, Object> map);

    public void  update(UserRegistrpost userRegistrpost,Map<String, Object> map);

    public void total(Map<String, Object> map);
}
