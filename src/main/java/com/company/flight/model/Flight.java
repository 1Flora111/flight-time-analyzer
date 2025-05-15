package com.company.flight.model;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
    public String id;
    public String aircraftType;
    public String aircraftNumber;
    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;
    public String fromAirport;
    public String toAirport;
    public List<String> crew;

    public Flight(String id, String aircraftType, String aircraftNumber, LocalDateTime departureTime,
                  LocalDateTime arrivalTime, String fromAirport, String toAirport, List<String> crew) {
        this.id = id;
        this.aircraftType = aircraftType;
        this.aircraftNumber = aircraftNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.crew = crew;
    }
}