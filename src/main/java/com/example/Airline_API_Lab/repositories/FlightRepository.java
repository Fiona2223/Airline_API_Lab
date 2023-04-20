package com.example.Airline_API_Lab.repositories;

import com.example.Airline_API_Lab.models.Flight;
import com.example.Airline_API_Lab.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
