package com.company;

public class Main {

    public static void main(String[] args) {
	for( int i=8;i>=2;i--){
	    int finalevalue=calculatevalue(1000,i);
        System.out.println(finalevalue);
    }
    }
    public static int calculatevalue(int amount,int interest){
        return (amount*interest);
    }
}
