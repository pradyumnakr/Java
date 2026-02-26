package com.company;
import java.util.*;
public class Main {
    static String usn,name,branch;
    static long phone;
    public static void getdetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the usn\n");
        usn=sc.nextLine();
        System.out.println("Enter the name\n");
        name=sc.nextLine();
        System.out.println("Enter the Branch\n");
        branch=sc.nextLine();
        System.out.println("Enter the phone number\n");
        phone=sc.nextLong();
    }
    public void putDetails(){
        System.out.println("\n\tUsn: "+usn+"\n\tName: "+name+"\n\tBranch: "+branch+"\n\tPhone: "+phone);
        System.out.println("\n");
    }

    public static void main(String[] args) {
	// write your code here
        int i,n;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of Students");
        n=in.nextInt();
        Main a[]=new Main[n];
        for(i=0;i<n;i++) {
             a[i]=new Main();
        }
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter the details of Student "+(i+1));
            a[i].getdetails();
        }
        for(i=0;i<n;i++)
        {
            System.out.println("\nThe details of Student "+(i+1));
            a[i].putDetails();
        }

    }
}
