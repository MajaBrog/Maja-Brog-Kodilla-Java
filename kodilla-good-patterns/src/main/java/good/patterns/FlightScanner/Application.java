package good.patterns.FlightScanner;

public class Application {
    public static void main(String[] args) {
        FlightSearchService flightSearchService = new FlightSearchService();
        flightSearchService.findFlightsTo("Goleniow");
        flightSearchService.findFlightsFrom("Goleniow");
        flightSearchService.findFlightsThrough("Goleniow", "Warsaw", "Paris");
        flightSearchService.findFlightsThrough("Goleniow", "Bergen", "Paris");
    }
}
