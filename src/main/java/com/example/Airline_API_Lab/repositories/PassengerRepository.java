package com.example.Airline_API_Lab.repositories;

import com.example.Airline_API_Lab.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
