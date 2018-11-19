package com.codeup.closetrycorner.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "outfit")
public class Outfit {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="garments_outfits",
            joinColumns = {@JoinColumn(name="outfit_id")},
            inverseJoinColumns = {@JoinColumn(name="garment_id")}
    )
    private List<Garment> garments;

    public Outfit(String description, String date) {
        this.description = description;
        this.date = date;
    }

    public Outfit(String description, User user, List<Garment> garments) {
        this.description = description;
        this.user = user;
        this.garments = garments;
    }

    public Outfit() {
    }

    public Outfit(String description) {
        this.description = description;
    }

    public Outfit(String description, String date, List<Garment> garments) {
        this.description = description;
        this.date = date;
        this.garments = garments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Garment> getGarments() {
        return garments;
    }

    public void setGarments(List<Garment> garments) {
        this.garments = garments;
    }
}
