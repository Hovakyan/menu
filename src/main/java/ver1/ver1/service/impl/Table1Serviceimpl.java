package ver1.ver1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ver1.ver1.entity.Table1;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.rapository.Table1Repository;
import ver1.ver1.service.Table1Service;
import ver1.ver1.service.UserpassService;

import java.util.*;

@Service
public class Table1Serviceimpl implements Table1Service {

    @Autowired
    Table1Repository table1Repository;
    @Autowired
    Table1Service table1Service;

    @Autowired
    UserpassServiceimpl userpassServiceimpl;

    @Autowired
    UserpassService userpassService;

    @Override
    public Table1 save(Table1 user) {
        return table1Repository.save(user);
    }

    @Override
    public Optional<Table1> getAllByName(String name) {
        return table1Repository.getAllByName(name);
    }


    @Override
    public Optional<Table1> findByName(String name) {
        return table1Repository.findByName(name);
    }

    @Override
    public Optional<Table1> findById(Integer id) {
        return table1Repository.findById(id);
    }

    @Override
    public void Add(UserRegistrpost userRegistrpost,Map<String, Object> map) {
        Table1 table1 = new Table1();
        if (table1Service.queryByName(userRegistrpost.getName()).isPresent()) {
        table1Service.queryByName(userRegistrpost.getName()).get().
        setPrice((table1Service.queryByName(
        userRegistrpost.getName()).get().getPrice()/table1Service.queryByName(
        userRegistrpost.getName()).get().getCount())*
        (table1Service.queryByName(userRegistrpost.getName()).get().getCount() +
        userRegistrpost.getCount()));
        table1Service.queryByName(userRegistrpost.getName()).get().setCount(
        table1Service.queryByName(userRegistrpost.getName()).get().getCount() +
        userRegistrpost.getCount());
        table1Repository.flush();
            map.put("success update list, AllList", table1Service.findAll());
        } else {
        table1.setName(userRegistrpost.getName());
        table1.setCount(userRegistrpost.getCount());
        table1.setPrice(userRegistrpost.getPrice() * table1.getCount());
        table1Service.save(table1);
            map.put("success, AllList", table1Service.findAll());
        }
    }

    @Override
    public void deleteById(Integer id) {
        table1Repository.deleteById(id);
    }

    @Override
    public Optional<Table1> queryById(Integer id) {
        return table1Repository.queryById(id);
    }

    @Override
    public Optional<Table1> queryByName(String name) {
        return table1Repository.queryByName(name);
    }

    @Override
    public void update(UserRegistrpost userRegistrpost,Map<String, Object> map) {
        if (userRegistrpost.getName() != null && table1Service.queryById(userRegistrpost.getId()).isPresent() ) {
            table1Service.queryById(userRegistrpost.getId()).get().setName(userRegistrpost.getName());
        }
        if (userRegistrpost.getCount() != null && table1Service.queryById(userRegistrpost.getId()).isPresent()) {
            table1Service.queryById(userRegistrpost.getId()).get().setCount(userRegistrpost.getCount());

        }
        if (userRegistrpost.getPrice() != null && table1Service.queryById(userRegistrpost.getId()).isPresent()) {
            table1Service.queryById(userRegistrpost.getId()).get().setPrice(userRegistrpost.getPrice());
        }
        table1Repository.flush();
        map.put("All", table1Service.findAll());
    }

    @Override
    public List<Table1> findAll() {
        return table1Repository.findAll();
    }

    @Override
    public Optional<Table1> getById(Integer id) {
        return table1Repository.getById(id);
    }

    @Override
    public void remuve(UserRegistrpost userRegistrpost,Map<String, Object> map) {
        if (table1Service.findById(userRegistrpost.getId()).isPresent() &&
                userpassService.findByLoginAndPassword(userRegistrpost.getLogin(),
                        userRegistrpost.getPassword()).isPresent() &&
                userRegistrpost.getLogin() != null && userRegistrpost.getPassword() != null) {
            table1Service.deleteById(userRegistrpost.getId());
            map.put("success, AllList", table1Service.findAll());
        }
    }

    @Override
    public void total(Map<String, Object> map) {
        Integer total = 0;
        for (Table1 price:table1Service.findAll()) {
           total +=  price.getPrice();
        }
        map.put("All", table1Service.findAll());
        map.put("Total",total);
    }
}
