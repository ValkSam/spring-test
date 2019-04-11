package com.spring.test.controller;

import com.spring.test.controller.request.HotelCreateRequest;
import com.spring.test.model.Hotel;
import com.spring.test.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> create(@RequestBody HotelCreateRequest request) {
        return ResponseEntity.ok(hotelService.create(
                request.getName(),
                request.getAddress(),
                request.getZip()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> get(@PathVariable UUID id) {
        Optional<Hotel> maybeHotel = hotelService.findById(id);
        return maybeHotel
                .map(e -> ResponseEntity.ok(maybeHotel.get()))
                .orElse(ResponseEntity.notFound().build());
    }

}
