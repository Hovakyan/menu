package ver1.ver1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ver1.ver1.entity.Table1;
import ver1.ver1.entity.Table2;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.entity.Userpass;
import ver1.ver1.rapository.Table2Rapository;
import ver1.ver1.service.Table2Servise;
import ver1.ver1.service.UserpassService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Table2Serviceimpl implements Table2Servise {

    @Autowired
    Table2Rapository table2Rapository;
    @Autowired
    Table2Servise table2Servise;
    @Autowired
    UserpassService userpassService;

    @Override
    public Table2 save(Table2 user) {
        return table2Rapository.save(user);
    }

    @Override
    public Optional<Table2> queryById(Integer id) {
        return table2Rapository.queryById(id);
    }

    @Override
    public Optional<Table2> findByName(String name) {
        return table2Rapository.findByName(name);
    }

    @Override
    public Optional<Table2> getAllByName(String name) {
        return table2Rapository.getAllByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        table2Rapository.deleteById(id);
    }

    @Override
    public Optional<Table2> findById(Integer id) {
        return table2Rapository.findById(id);
    }

    @Override
    public List<Table2> findAll() {
        return table2Rapository.findAll();
    }

    @Override
    public Optional<Table2> queryByName(String name) {
        return table2Rapository.queryByName(name);
    }

    @Override
    public void update(UserRegistrpost userRegistrpost,Map<String, Object> map) {
        if (userRegistrpost.getName() != null && table2Servise.queryById(userRegistrpost.getId()).isPresent() ) {
            table2Servise.queryById(userRegistrpost.getId()).get().setName(userRegistrpost.getName());
        }
        if (userRegistrpost.getCount() != null && table2Servise.queryById(userRegistrpost.getId()).isPresent()) {
            table2Servise.queryById(userRegistrpost.getId()).get().setCount(userRegistrpost.getCount());

        }
        if (userRegistrpost.getPrice() != null && table2Servise.queryById(userRegistrpost.getId()).isPresent()) {
            table2Servise.queryById(userRegistrpost.getId()).get().setPrice(userRegistrpost.getPrice());
        }
        table2Rapository.flush();
        map.put("All", table2Servise.findAll());
    }

    @Override
    public void Add(UserRegistrpost userRegistrpost, Map<String, Object> map) {
        Table2 table2 = new Table2();
        if (table2Servise.queryByName(userRegistrpost.getName()).isPresent()) {
     table2Servise.queryByName(userRegistrpost.getName()).get().
     setPrice((table2Servise.queryByName(
     userRegistrpost.getName()).get().getPrice()/table2Servise.queryByName(
     userRegistrpost.getName()).get().getCount())*
     (table2Servise.queryByName(userRegistrpost.getName()).get().getCount() +
     userRegistrpost.getCount()));
     table2Servise.queryByName(userRegistrpost.getName()).get().setCount(
     table2Servise.queryByName(userRegistrpost.getName()).get().getCount() +
     userRegistrpost.getCount());
     table2Rapository.flush();
     map.put("success update list, AllList", table2Servise.findAll());
        } else {
     table2.setName(userRegistrpost.getName());
     table2.setCount(userRegistrpost.getCount());
     table2.setPrice(userRegistrpost.getPrice() * table2.getCount());
     table2Servise.save(table2);
     map.put("success, AllList", table2Servise.findAll());
        }
    }

    @Override
    public void remuve(UserRegistrpost userRegistrpost,Map<String, Object> map) {
        if (table2Servise.findById(userRegistrpost.getId()).isPresent() &&
                userpassService.findByLoginAndPassword(userRegistrpost.getLogin(),
                    userRegistrpost.getPassword()).isPresent() &&
                userRegistrpost.getLogin() != null && userRegistrpost.getPassword() != null) {
            table2Servise.deleteById(userRegistrpost.getId());
            map.put("success, AllList", table2Servise.findAll());
        }
    }

    @Override
    public void total(Map<String, Object> map) {
        Integer total = 0;
        for (Table2 price:table2Servise.findAll()) {
            total +=  price.getPrice();
        }
        map.put("All", table2Servise.findAll());
        map.put("Total",total);
    }

}
