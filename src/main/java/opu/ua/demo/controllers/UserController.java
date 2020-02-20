package opu.ua.demo.controllers;

import opu.ua.demo.model.User;
import opu.ua.demo.services.UserService;
import opu.ua.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService service;

    @Autowired
    public void setService(UserService service){
        this.service = service;
    }


    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getAllUsers(@PathVariable long id){
        return service.getUser(id);
    }

    @PutMapping
    public void saveOrUpdateUser(@RequestBody User user){
        service.saveOrUpdateUser(user);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        service.deleteUser(id);
    }

}
