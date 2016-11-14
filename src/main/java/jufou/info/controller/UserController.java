package jufou.info.controller;

import jufou.info.impl.UserServiceImpl;
import jufou.info.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HQ on 10/18/16.
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method= RequestMethod.GET,value="/user/nickname/{id}")
    public void printUserNickname(@PathVariable long id) {
        userService.test();
        int z=Integer.parseInt("AA");
    }
    @RequestMapping(method= RequestMethod.PUT,value="/user/nickname")
    public User putUserNickname(@RequestBody User user) {
        System.out.println(user.getName());
        return user;
    }
}
