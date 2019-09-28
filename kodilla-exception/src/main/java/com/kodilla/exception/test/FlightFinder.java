package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    
    public static boolean findFlight(Flight flight) throws RouteNotFoundException {
        
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Heathrow Airport", true);
        airports.put("Stockholm Arlanda Airport", true);
        airports.put("Charles de Gaulle Airport", false);
        airports.put("Warsaw Chopin Airport", false);

        if (airports.containsKey(flight.getArrivalAirport())) {
            Boolean AirportFound = airports.entrySet().stream()
                    .filter(e -> e.getKey().equals(flight.getArrivalAirport()))
                    .map(Map.Entry::getValue)
                    .allMatch(e -> e == true);
            return AirportFound;
        } else {
            throw new RouteNotFoundException("Arrival airport not found");
        }


    }

}
