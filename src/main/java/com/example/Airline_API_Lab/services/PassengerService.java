package com.example.Airline_API_Lab.services;

import com.example.Airline_API_Lab.models.Flight;
import com.example.Airline_API_Lab.models.Passenger;
import com.example.Airline_API_Lab.models.PassengerDTO;
import com.example.Airline_API_Lab.repositories.FlightRepository;
import com.example.Airline_API_Lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

//    add new passenger
    public Passenger addNewPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

//    find flight by id
    public Passenger addPassengerToFlight(Long id, Long flightId) {
        Flight flight = flightRepository.findById(flightId).get();

//    find passenger by id
        Passenger passenger = passengerRepository.findById(id).get();
        return passenger;
    }

//    remove passenger
    public void removePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

        public Passenger updatePassenger(PassengerDTO passengerDTO, Long id) {
            Passenger passenger = passengerRepository.findById(id).get();
            passenger.setName(passengerDTO.getName());
            passenger.setEmail(passengerDTO.getEmail());

        return passengerRepository.save(passenger);
    }


}
