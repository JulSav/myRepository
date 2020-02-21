package opu.ua.demo.controllers;

import opu.ua.demo.model.Activity;
import opu.ua.demo.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class ActivityController {

    private ActivityService service;

    @Autowired
    public void setService(ActivityService service){
        this.service = service;
    }


   // @GetMapping("/{userId}/activity")
    //public List<Activity> getAllActivities(@PathVariable long userId){
    //    return service.getAllActivities(userId);
    //}

    @GetMapping("/{userId}/activity")
    public Optional<Activity> getAllActivity(@PathVariable long userId){
       return service.getActivity(userId);
    }


    @PostMapping("/activity")
    public void addActivity(@RequestBody Activity activity){
        service.addActivity(activity);
    }

    @DeleteMapping("/{userId}/activity")
    public void deleteActivity(@PathVariable long userId) {
        service.deleteActivity(userId);
    }


    @PutMapping("/activity")
    public void saveOrUpdateActivity(@RequestBody Activity activity){
       service.saveOrUpdateActivity(activity);
    }





}
