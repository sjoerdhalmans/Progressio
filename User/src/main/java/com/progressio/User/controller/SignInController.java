package com.progressio.User.controller;

import com.progressio.User.logic.UserCollectionLogic;
import com.progressio.User.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SignInController {
    @Autowired
    UserCollectionLogic userCollectionLogic;

    @GetMapping(value = "/getUserById/{userId}")
    public User userByIdEndPoint(@PathVariable(value = "userId") Long id) {
        return userCollectionLogic.GetUserById(id);
    }

    @PostMapping(value = "/addUser")
    public User addUserEndPoint(@RequestBody User user) {
        user = userCollectionLogic.AddUser(user);

        return user;
    }

    @DeleteMapping(value = "/removeUser")
    public void removeUser(@RequestBody User user ) {
        userCollectionLogic.RemoveUser(user);
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return userCollectionLogic.GetAllUsers();
    }
}
