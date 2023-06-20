package com.crud.crud.Controllers;

import com.crud.crud.Models.UserModel;
import com.crud.crud.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return this.userService.createUser(user);
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getId(@PathVariable("id") Long id){
        return this.userService.getId(id);
    }
    @PutMapping(path="/{id}")
    public UserModel updateUser(@RequestBody UserModel user,@PathVariable("id") Long id){
        return this.userService.updateUser(user,id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok= this.userService.deleteUser(id);
        return ok ? "User with id: " + id + " deleted!" : "Error, have a problem";
    }
}
