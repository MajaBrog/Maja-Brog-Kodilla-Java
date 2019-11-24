package good.patterns.FlightScanner;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionsList {
    private Map<Airport, Airport> connectionsList = new HashMap<>();

    public ConnectionsList() {
        this.connectionsList = connectionsList;
        connectionsList.put(new Airport("Goleniow"), new Airport("Warsaw"));
        connectionsList.put(new Airport("Goleniow"), new Airport("Bergen"));
        connectionsList.put(new Airport("Goleniow"), new Airport("Dublin"));
        connectionsList.put(new Airport("Warsaw"), new Airport("Paris"));
        connectionsList.put(new Airport("Warsaw"), new Airport("Goleniow"));
        connectionsList.put(new Airport("Warsaw"), new Airport("Prague"));
        connectionsList.put(new Airport("Krakow"), new Airport("Warsaw"));
        connectionsList.put(new Airport("Krakow"), new Airport("Dublin"));
        connectionsList.put(new Airport("London"),new Airport("Warsaw"));
        connectionsList.put(new Airport("London"),new Airport("Dublin"));
        connectionsList.put(new Airport("London"), new Airport("Prague"));
    }

    public Map<Airport, Airport> getAirportsList() {
        return connectionsList;
    }

}
