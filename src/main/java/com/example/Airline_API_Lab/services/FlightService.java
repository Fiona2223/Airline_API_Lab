package com.example.Airline_API_Lab.services;

import com.example.Airline_API_Lab.models.Flight;
import com.example.Airline_API_Lab.models.Passenger;
import com.example.Airline_API_Lab.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FlightService {
    @Autowired
   FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight) {
       return flightRepository.save(flight);
    }

    public Flight addNewPassengerToFlight(Flight flight, Passenger passenger){
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        return flightRepository.save(flight);
    }

//    filter flights by destination
    public List<Flight> filterFlights(String destination) {
        List<Flight> allFlights = flightRepository.findAll();
        List<Flight> filteredFlights = new ArrayList<>();
        return filteredFlights;
    }

//    cancel flight
    public void cancelFlightById(Long id){
        flightRepository.deleteById(id);
    }
}
