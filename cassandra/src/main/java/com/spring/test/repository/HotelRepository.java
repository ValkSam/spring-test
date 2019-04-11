package com.spring.test.repository;

import com.spring.test.model.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface HotelRepository extends CrudRepository<Hotel, UUID> {

    Optional<Hotel> findById(UUID id);

}
