package opu.ua.demo.repository;

import opu.ua.demo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
     //List<Activity> findAllByUserId(long userId);
     Activity findActivityByUserId(long userId);

     //void removeActivityByUserId(long userId);
     @Transactional
     void deleteActivityByUserId(long userId);





}
