package good.patterns.Order.Model;

import good.patterns.Order.Model.Address;

public class User {
    private String login;
    private String name;
    private String surname;
    private Address deliveryAddress;
    private Address billingAddress;
    private String email;


    public User(String login, String name, String surname, Address deliveryAddress, Address billingAddress, String email) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
