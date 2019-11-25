package good.patterns.FlightScanner;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {
    private List<Connection> connectionList;

    FlightSearchService() {
        this.connectionList = new ConnectionsList().getAirportsList();
    }

    private List<Airport> possibleAirports;

    public void findFlightsFrom(String airport) {
        possibleAirports = connectionList.stream()
                .filter(n -> n.getArrivalAirport().getName().equals(airport))
                .map(Connection::getDepartureAirport)
                .collect(Collectors.toList());
        if (possibleAirports.size() > 0)
            System.out.println("You can fly from " + airport + " to " + possibleAirports);
        else
            System.out.println("Sorry we did not find matching connection");
    }

    void findFlightsTo(String airport) {
        possibleAirports = connectionList.stream()
                .filter(n -> n.getDepartureAirport().getName().equals(airport))
                .map(Connection::getArrivalAirport)
                .collect(Collectors.toList());
        if (possibleAirports.size() > 0)
            System.out.println("You can fly to " + airport + " from " + possibleAirports);
        else
            System.out.println("Sorry we did not find matching connection");
    }

    public void findFlightsThrough(String departureAirport, String transferAirport, String arrivalAirport) {
        boolean possibleTransfer = connectionList.stream()
                .filter(n -> n.getDepartureAirport().getName().equals(departureAirport))
                .anyMatch(n -> n.getArrivalAirport().getName().equals(transferAirport));
        boolean possibleArrival = connectionList.stream()
                .filter(n -> n.getDepartureAirport().getName().equals(transferAirport))
                .anyMatch(n -> n.getArrivalAirport().getName().equals(arrivalAirport));
        if (possibleTransfer && possibleArrival)
            System.out.println("You can fly from " + departureAirport + " to " + transferAirport + " and then to " + arrivalAirport);
        else
            System.out.println("Sorry we did not find matching connection");
    }
}
