package com.company;

public class VipPerson {
    private String name;
    private int creditlimit;
    private String emailAdress;

    public VipPerson(String name, int creditlimit, String emailAdress) {
        this.name = name;
        this.creditlimit = creditlimit;
        this.emailAdress = emailAdress;
    }

    public VipPerson(String name, int creditlimit) {
        this(name,creditlimit,"default@gmail.com");
    }

    public VipPerson(){
        this("praddy",5000,"default@gmail.com");
    }

}
