package com.codeup.closetrycorner.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="garments")
public class Garment {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String date;

    @Column(nullable=false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="garments_categories",
            joinColumns = {@JoinColumn(name="garment_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private List<Category> categories;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="garments_outfits",
            joinColumns = {@JoinColumn(name="garment_id")},
            inverseJoinColumns = {@JoinColumn(name="outfit_id")}
    )
    private List<Outfit> outfits;


    public Garment(String date, String image, User user, List<Category> categories) {
        this.date = date;
        this.image = image;
        this.user = user;
        this.categories = categories;
    }

    public Garment(String image, User user) {
        this.image = image;
        this.user = user;
    }

    public Garment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Outfit> getOutfits() {
        return outfits;
    }

    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }
}