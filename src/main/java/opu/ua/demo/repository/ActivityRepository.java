package opu.ua.demo.repository;

import opu.ua.demo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
     //List<Activity> findAllByUserId(long userId);
     Optional<Activity> findActivityByUserId(long userId);

     //void removeActivityByUserId(long userId);
     @Transactional
     void deleteActivityByUserId(long userId);





}
