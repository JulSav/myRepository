package opu.ua.demo.services;

import opu.ua.demo.model.User;
import opu.ua.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    public void addUser(User user){
        repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(long id){
        return repository.findUserById(id);
    }

    public void deleteUser(long id){
        repository.deleteById(id);
    }

    public void saveOrUpdateUser(User user){
        repository.save(user);
    }




}
