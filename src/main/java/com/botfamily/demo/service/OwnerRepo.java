package com.botfamily.demo.service;

import com.botfamily.demo.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
