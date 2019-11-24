package good.patterns.FlightScanner;

public class Application {
    public static void main(String[] args) {
        FlightSearchService flightSearchService=new FlightSearchService();
        System.out.println(flightSearchService.findFlightsTo("Dublin"));
        System.out.println(flightSearchService.findFlightsTo("Warsaw"));
    }
}
