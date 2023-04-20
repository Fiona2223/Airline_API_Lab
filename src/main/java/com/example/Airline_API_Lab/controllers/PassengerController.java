package com.example.Airline_API_Lab.controllers;


import com.example.Airline_API_Lab.models.Passenger;
import com.example.Airline_API_Lab.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")

public class PassengerController {

    @Autowired
    PassengerService passengerService;

//     Display  all passengers details
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }


//   Display  specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
        Optional<Passenger> passenger = passengerService.getPassengerById(id);
        if (passenger.isPresent()){
            return new ResponseEntity<>(passenger.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//     Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger){
        Passenger newPassenger = passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(newPassenger, HttpStatus.CREATED);
    }

//    Delete passenger details
@DeleteMapping(value = "/{id}")
public ResponseEntity<Long> removePassenger(@PathVariable Long id){
    passengerService.removePassenger(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Passenger> addPassengerToFlight(
            @PathVariable Long id,
            @RequestParam Long flightId
    ){
        Passenger passenger = passengerService.addPassengerToFlight(id, flightId);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }


}
