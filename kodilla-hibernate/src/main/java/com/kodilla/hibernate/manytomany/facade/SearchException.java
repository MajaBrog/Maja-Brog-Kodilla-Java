package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {

    public static String ERR_NAME_FRAGMENT_IS_NULL = "Name fragment cannot be null";

    public SearchException(String message) {
        super(message);
    }
}
