package ver1.ver1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ver1.ver1.entity.UserRegistrpost;
import ver1.ver1.service.Table1Service;
import ver1.ver1.service.Table2Servise;
import ver1.ver1.service.UserpassService;
import ver1.ver1.service.impl.Table1Serviceimpl;
import ver1.ver1.service.impl.Table2Serviceimpl;
import ver1.ver1.service.impl.UserpassServiceimpl;


import java.util.HashMap;
import java.util.Map;



@RestController
public class Controller {

    @Autowired
    UserpassService userpassService;

    @Autowired
    Table1Service table1Service;

    @Autowired
    Table2Servise table2Servise;

    @Autowired
    Table1Serviceimpl table1Serviceimpl;

    @Autowired
    Table2Serviceimpl table2Serviceimpl;

    @Autowired
    UserpassServiceimpl userpassServiceimpl;


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public Map<String, Object> Addpass(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        userpassServiceimpl.Add(userRegistrpost,map);
        return map;
    }

    @RequestMapping(value = "/addT1", method = RequestMethod.POST)
    public Map<String, Object> Addptable1(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table1Serviceimpl.Add(userRegistrpost,map);
        return map;

    }

    @RequestMapping(value = "/addT2", method = RequestMethod.POST)
    public Map<String, Object> Addptable2(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table2Serviceimpl.Add(userRegistrpost,map);
        return map;
    }

    @RequestMapping(value = "/remuveT1", method = RequestMethod.DELETE)
    public Map<String, Object> Delete1(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table1Service.remuve(userRegistrpost,map);
        return map;

    }

    @RequestMapping(value = "/remuveT2", method = RequestMethod.DELETE)
    public Map<String, Object> Delete2(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table2Servise.remuve(userRegistrpost,map);
        return map;

    }

    @RequestMapping(value = "/viewT1", method = RequestMethod.GET)
    public Map<String, Object> view1() {
        Map<String, Object> map = new HashMap<>();
        table1Service.total(map);
        return map;
    }

    @RequestMapping(value = "/viewT2", method = RequestMethod.GET)
    public Map<String, Object> view2() {
        Map<String, Object> map = new HashMap<>();
        table2Servise.total(map);
        return map;
    }

    @RequestMapping(value = "/editT1", method = RequestMethod.POST)
    public Map<String, Object> editapTl(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table1Service.update(userRegistrpost,map);
        return map;
    }

    @RequestMapping(value = "/editT2", method = RequestMethod.POST)
    public Map<String, Object> editapT2(@RequestBody UserRegistrpost userRegistrpost) {
        Map<String, Object> map = new HashMap<>();
        table2Servise.update(userRegistrpost,map);
        return map;
    }

}
