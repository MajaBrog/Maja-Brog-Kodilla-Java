package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightFinderRunner {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("Warsaw Chopin Airport", "Alicante Airport"));
        flights.add(new Flight("Warsaw Chopin Airport", "Heathrow Airport"));
        flights.add(new Flight("Warsaw Chopin Airport", "Charles de Gaulle Airport"));
        for (Flight flight : flights) {
            try {
                if (FlightFinder.findFlight(flight)) {
                    System.out.println("The flight from " + flight.getDepartureAirport() +
                            " to " + flight.getArrivalAirport() + " is possible");
                } else {
                    System.out.println("Sorry, the is no existing flights to " + flight.getArrivalAirport());
                }
            } catch (RouteNotFoundException e) {
                System.out.println("Arrival Airport not found!");
            } finally {
                System.out.println("Thank you for using our Flight Finder!");
            }
        }
    }
}
