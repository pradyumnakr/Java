package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int count=0;
        while(count!=10){
            System.out.println("the count is "+ count);
            count++;
        }
        count=10;
        while(true){
            if(count==14){
                break;
            }
            else{
                System.out.println(count);
                count++;
            }

        }
        count=14;
        do{
            System.out.println("the count is " + count);
            count++;
        }while(count!=20);
    }
}
