package opu.ua.demo.repository;

import opu.ua.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id); //??? can make it with Optional findById()
}
