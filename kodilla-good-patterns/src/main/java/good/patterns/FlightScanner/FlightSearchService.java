package good.patterns.FlightScanner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSearchService {
    private Map<Airport,Airport> connectionList;
    private List<Airport> foundConnections;

    public FlightSearchService() {
        this.connectionList = new ConnectionsList().getAirportsList();
    }

    public List<Airport> findFlightsFrom(String airport){
        return connectionList.entrySet().stream()
                .filter(n -> n.getKey().getName().equals(airport))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    public List<Airport> findFlightsTo(String airport){
        return connectionList.entrySet().stream()
                .filter(n->n.getValue().getName().equals(airport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<Airport> findFlightsThrough(String departureAirport,String arrivalAirport){
        List<Airport> possibleFlightsFromDepartureAirport= connectionList.keySet().stream()
                .filter(n->n.getName().equals(departureAirport))
                .collect(Collectors.toList());
        return connectionList.entrySet().stream()
                .filter(n->possibleFlightsFromDepartureAirport.contains(n.getKey()))
                .filter(n->n.getValue().getName().equals(arrivalAirport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "FlightSearchService{" +
                "foundConnections=" + foundConnections +
                '}';
    }
}
