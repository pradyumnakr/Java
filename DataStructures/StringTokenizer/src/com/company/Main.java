package com.company;
import java.util.*;
public class Main {
    public String readCustomer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name and DOB in <name,dd/mm/yyyy> format\n");
        String str=sc.next();
        if(!str.startsWith("<")||!str.endsWith(">"))
        {
            System.out.println("Please enter in proper format\n");
            System.exit(0);
        }
        return str;
    }
    public void displayCustomer(String data){
        String st=data.substring(0,data.length());
        //System.out.println(st);
        StringTokenizer token=new StringTokenizer(st,"<,/>");
        //System.out.println(token);
        String fin=null;
        while (token.hasMoreTokens())
        {
            if(fin==null)
            {
                fin=token.nextToken();
            }
            else
                fin=fin+" ,"+token.nextToken();
        }
        System.out.println("The Resultant string is "+" <"+fin+"> ");

    }

    public static void main(String[] args) {
	// write your code here
        Main c=new Main();
        String data;
        data=c.readCustomer();
        c.displayCustomer(data);
    }
}
