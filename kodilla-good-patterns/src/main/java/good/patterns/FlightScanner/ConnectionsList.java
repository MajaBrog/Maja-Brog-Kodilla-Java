package good.patterns.FlightScanner;

import java.util.ArrayList;
import java.util.List;

public class ConnectionsList {
    private List<Connection> connectionsList = new ArrayList<>();

    public ConnectionsList() {
        this.connectionsList = connectionsList;
        connectionsList.add(new Connection(new Airport("Goleniow"), new Airport("Warsaw")));
        connectionsList.add(new Connection(new Airport("Goleniow"), new Airport("Bergen")));
        connectionsList.add(new Connection(new Airport("Goleniow"), new Airport("Dublin")));
        connectionsList.add(new Connection(new Airport("Warsaw"), new Airport("Paris")));
        connectionsList.add(new Connection(new Airport("Warsaw"), new Airport("Goleniow")));
        connectionsList.add(new Connection(new Airport("Warsaw"), new Airport("Prague")));
        connectionsList.add(new Connection(new Airport("Krakow"), new Airport("Warsaw")));
        connectionsList.add(new Connection(new Airport("Krakow"), new Airport("Dublin")));
        connectionsList.add(new Connection(new Airport("London"), new Airport("Warsaw")));
        connectionsList.add(new Connection(new Airport("London"), new Airport("Dublin")));
        connectionsList.add(new Connection(new Airport("London"), new Airport("Prague")));
    }

    public List<Connection> getAirportsList() {
        return connectionsList;
    }

}
