package com.company;

public class Main {

    public static void main(String[] args) {
        byte bytevalue = 10;
        short shortvalue = 20;
        int intvalue = 40;
        long longtotal = 50000L + 10 * (bytevalue + intvalue + shortvalue);
        System.out.println("longtotal="  longtotal);
    }
}
