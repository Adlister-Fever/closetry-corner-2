package com.codeup.closetrycorner.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Garment> garments;

    public Category() {
    }

    public Category(String name, List<Garment> garments) {
        this.name = name;
        this.garments = garments;
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
