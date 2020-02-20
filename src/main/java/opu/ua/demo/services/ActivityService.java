package opu.ua.demo.services;

import opu.ua.demo.model.Activity;
import opu.ua.demo.model.User;
import opu.ua.demo.repository.ActivityRepository;
import opu.ua.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private ActivityRepository repository;

    @Autowired
    public void setRepository(ActivityRepository repository){
        this.repository = repository;
    }

    public void addActivity(Activity activity) {
        repository.save(activity);
    }
    //public List<Activity> getAllActivities(Long userId){
     //   return repository.findAllByUserId(userId);
    //}

    public Activity getActivity(long userId){
        return repository.findActivityByUserId(userId);
    }

    public void deleteActivity(long userId){
        repository.deleteActivityByUserId(userId);
    }

    public void saveOrUpdateActivity(Activity activity){
           repository.save(activity);
    }




}
