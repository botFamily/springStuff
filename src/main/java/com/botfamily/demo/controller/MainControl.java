package com.botfamily.demo.controller;

import com.botfamily.demo.model.*;
import com.botfamily.demo.service.CarRepo;
import com.botfamily.demo.service.GymRepo;
import com.botfamily.demo.service.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RestController
public class MainControl {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private GymRepo gymRepo;

    @GetMapping("/cars")
    public Iterable<Car> cars(){

        Car car = new Car();
        Gym gym = new Gym("gym1");
        Gym gym2 = new Gym("gym2");
        Owner owner = new Owner("Alex",
                new Address("Vitebsk", "Chcalova", "Belarus"),
                Arrays.asList(gym, gym2));


        gymRepo.save(gym);
        gymRepo.save(gym2);

        ownerRepo.save(owner);

        car.setCarType(CarType.AUDI);
        car.setOwner(owner);

        carRepo.save(car);

        return carRepo.findAll();
    }


}
