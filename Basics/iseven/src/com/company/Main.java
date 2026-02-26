package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean value=isEven(5);
        System.out.println(value);
        int count=5;
        int total=0;
        while (count<=20){
            if(isEven(count)){
                total++;
                System.out.println(count);
                count++;
            }
            count++;
        }
        System.out.println("The total number of even numbers are " + total);
    }
    public static boolean isEven(int n){
        if(n%2==0)
            return true;
        return false;
    }
}
