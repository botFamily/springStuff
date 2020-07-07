package com.botfamily.demo.service;

import com.botfamily.demo.model.Gym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepo extends CrudRepository<Gym, Long> {
}
