package com.botfamily.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Owner owner;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    public Car() {
    }
}
