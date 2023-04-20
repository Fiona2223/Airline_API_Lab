package com.example.Airline_API_Lab.components;

import com.example.Airline_API_Lab.models.Flight;
import com.example.Airline_API_Lab.models.Passenger;
import com.example.Airline_API_Lab.repositories.FlightRepository;
import com.example.Airline_API_Lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

//      flights details
        Flight emiratesAirlines = new Flight("Dubai", 360,
                LocalDate.of(2023,05,19),
                LocalTime.of(17,00) );
        flightRepository.save(emiratesAirlines);

        Flight britishAirlines = new Flight("London", 300,
                LocalDate.of(2023,05,21),
                LocalTime.of(14,00) );
        flightRepository.save(britishAirlines);

        Flight ghanaAirlines = new Flight("Accra", 280,
                LocalDate.of(2023,06,10),
                LocalTime.of(10,20) );
        flightRepository.save(ghanaAirlines);


        Flight turkishAirlines = new Flight("Istanbul", 150,
                LocalDate.of(2023,07,18),
                LocalTime.of(22,19) );
        flightRepository.save(turkishAirlines);


//        passengers details
        Passenger passenger1  = new Passenger("John", "John@bnta.com");
        passengerRepository.save(passenger1);

        Passenger passenger2  = new Passenger("Eva", "Eva@bnta.com");
        passengerRepository.save(passenger2);

        Passenger passenger3  = new Passenger("Kojo", "Kojo@bnta.com");
        passengerRepository.save(passenger3);

        Passenger passenger4  = new Passenger("Amy", "Amy@bnta.com");
        passengerRepository.save(passenger4);

        passenger1.getFlights().add(emiratesAirlines);
        passenger2.getFlights().add(britishAirlines);
        passenger3.getFlights().add(ghanaAirlines);
        passenger3.getFlights().add(emiratesAirlines);
        passenger4.getFlights().add(turkishAirlines);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);
    }
}
