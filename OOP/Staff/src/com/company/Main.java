package com.company;
import java.util.*;
public class Main {
    String name;
    int staffid;
    long phone;
    float salary;

    public void getSdetails() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the Staff ID: ");
        staffid = in.nextInt();
        System.out.println("\nEnter the Name: ");
        name = in.next();
        System.out.println("\nEnter the Staff Phone Number: ");
        phone = in.nextLong();
        System.out.println("Enter the Staff Salary: ");
        salary = in.nextFloat();
    }

    public void putSdetails() {
        System.out.println("\n\tStaff ID: " + staffid + "\n\tNAME: " + name + "\n\tPHONE: " + phone + "\n\tSALARY: " + salary + "\n");
    }

}
class Teaching extends Main {
    String domain, publication;

    public void getTdetails() {
        super.getSdetails();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the domain\n");
        domain = in.nextLine();
        System.out.println("Enter the publication\n");
        publication = in.nextLine();
    }

    public void putTdetails() {
        super.putSdetails();
        System.out.println("\n\tDomain: " + domain + "\n\tPublication: " + publication);
    }

}
class Technical extends Main{
    String skills;
    public void getT1details(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the skills\n");
        skills=in.nextLine();
    }
    public void putT1details(){
        System.out.println("\n\tSkills: "+skills);
    }
}
class Contract extends Main
{
    String period;
    public void getCdetails(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the period\n");
        period=in.nextLine();
    }
    public void putCdetails(){
        System.out.println("\n\tPeriod: "+period);
    }
}
 public class Inheritence {


    public static void main(String[] args) {
        // write your code here
        int n,i;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of staff\n");
        n=in.nextInt();
        Teaching t[]=new Teaching[n];
        Technical t1[]=new Technical[n];
        Contract c[]=new Contract[n];
        for(i=0;i<n;i++){
            t[i]=new Teaching();
            t1[i]=new Technical();
            c[i]=new Contract();
        }
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the details of Staff "+(i+1));
            t[i].getSdetails();
            t1[i].getT1details();
            c[i].getCdetails();
            System.out.println("..................................");
        }
        for(i=0;i<n;i++)
        {
            System.out.println("The details of staff "+(i+1));
            t[i].putTdetails();
            t1[i].putT1details();
            c[i].putCdetails();
            System.out.println("....................................");
        }

    }
}
