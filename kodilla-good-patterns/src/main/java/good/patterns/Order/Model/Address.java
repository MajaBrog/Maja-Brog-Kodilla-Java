package good.patterns.Order.Model;

public class Address {
    private String country;
    private String city;
    private String postalCode;
    private String streetName;
    private String buildingNumber;
    private int houseNumber;

    public Address(String country, String city, String postalCode, String streetName, String buildingNumber, int houseNumber) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.houseNumber = houseNumber;
    }


    @Override
    public String toString() {
        return "{Country='" + country + '\'' +
                ", City='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
