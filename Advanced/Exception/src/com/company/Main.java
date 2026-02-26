package com.company;
import java.util.*;
public class Main {


    public static void main(String[] args) {
	// write your code here
        int a,b,c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of a\n");
        a=sc.nextInt();
        System.out.println("Enter the value of b\n");
        b=sc.nextInt();
        try{
            c=a/b;
            System.out.println("\n\t The result of "+a+"/"+b+" is: "+c);

        }
        catch (ArithmeticException ae){
            System.out.println("Division by Zero\n");
        }

    }
}
