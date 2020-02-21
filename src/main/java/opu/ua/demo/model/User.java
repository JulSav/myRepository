package opu.ua.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //Add this entity to database
@Table(name = "users")

@NoArgsConstructor
@AllArgsConstructor
@Data //change writing getters,  setters, constructors and so on
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private int dailyGoal;
    private float weight;
    private float height;
    private String roles;
    private boolean isActive;

    //add one more entity from the photo

}
