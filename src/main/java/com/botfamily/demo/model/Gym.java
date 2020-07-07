package com.botfamily.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "gyms")
    private List<Owner> owners = new ArrayList<>();

    public Gym(String name) {
        this.name = name;
    }

    public Gym() {

    }
}
