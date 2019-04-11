package com.spring.test.service;

import com.spring.test.model.Hotel;
import com.spring.test.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel create(String name,
                        String address,
                        String zip) {
        Hotel hotel = Hotel.builder()
                .id(UUID.randomUUID())
                .name(name)
                .address(address)
                .zip(zip)
                .build();
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> findById(UUID id) {
        return hotelRepository.findById(id);
    }

}
