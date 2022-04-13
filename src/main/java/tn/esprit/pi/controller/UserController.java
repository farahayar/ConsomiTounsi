package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.User;
import tn.esprit.pi.services.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    List<User> showAllUsers() {
        return userService.retrieveUsers();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    User showUser(@PathVariable("idUser") Long Userid) {
        return userService.retrieveUserById(Userid);
    }

    @PostMapping("/adduser")
    @ResponseBody
    User addUser(@RequestBody User u) {

        return userService.saveUser(u);
    }

    @PutMapping("/updatePc")
    @ResponseBody
    User alterUser(@RequestBody User u) {
        return userService.updateUser(u);
    }

    @DeleteMapping("/userdel/{id}")
    @ResponseBody
    void deleteUser(@PathVariable("userid") Long Userid) {
        userService.deleteUser(Userid);
    }

}