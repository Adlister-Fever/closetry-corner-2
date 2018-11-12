package com.codeup.closetrycorner.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="followers")
public class Follower {

    @Id
    @GeneratedValue
    private long id;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="follow_user",
            joinColumns = {@JoinColumn(name="follower_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private List<Follower> followers;

    public Follower() {
    }

    public Follower(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
