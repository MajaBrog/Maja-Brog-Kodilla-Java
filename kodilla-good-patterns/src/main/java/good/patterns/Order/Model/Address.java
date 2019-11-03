package good.patterns.Order;

public class Address {
    private String Country;
    private String City;
    private String postalCode;
    private String streetName;
    private String buildingNumber;
    private int houseNumber;

    public Address(String country, String city, String postalCode, String streetName, String buildingNumber, int houseNumber) {
        Country = country;
        City = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.houseNumber = houseNumber;
    }


    @Override
    public String toString() {
        return "Address{" +
                "Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
