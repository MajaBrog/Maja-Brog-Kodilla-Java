package com.kodilla.stream.forumuser;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public  final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1,"Maja",'F', LocalDate.of(1994, Month.DECEMBER, 2),10));
        forumUserList.add(new ForumUser(2,"Marek",'M', LocalDate.of(1989, Month.JANUARY, 13),30));
        forumUserList.add(new ForumUser(3,"Kasia",'F', LocalDate.of(1997, Month.JULY, 30),45));
        forumUserList.add(new ForumUser(4,"Ania",'F', LocalDate.of(1950, Month.JANUARY, 22),5));
        forumUserList.add(new ForumUser(5,"Jarek",'M', LocalDate.of(1950, Month.JULY, 5),32));
        forumUserList.add(new ForumUser(6,"Patryk",'M', LocalDate.of(2002, Month.DECEMBER, 11),67));
        forumUserList.add(new ForumUser(7,"Tomek",'M', LocalDate.of(2005, Month.JANUARY, 15),2));
        forumUserList.add(new ForumUser(8,"Asia",'F', LocalDate.of(1992, Month.SEPTEMBER, 4),11));
        forumUserList.add(new ForumUser(9,"Waldek",'M', LocalDate.of(1988, Month.NOVEMBER, 7),16));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
