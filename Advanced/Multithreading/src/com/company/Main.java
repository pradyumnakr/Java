package com.company;
import java.util.*;
public class Main {
    static int a[]=new int[50];
    static int n;
    public static void main(String[] args)throws InterruptedException {
	// write your code here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements\n");
        n=sc.nextInt();
        Runnable r1=new Runnable1();
        Thread t1=new Thread(r1);
        t1.start();
        Thread.sleep(5000);
        Runnable r2=new Runnable2();
        Thread t2=new Thread(r2);
        t2.start();
        Thread.sleep(5000);
        Runnable r3=new Runnable3();
        Thread t3=new Thread(r3);
        t3.start();

    }
}
class Runnable1 implements Runnable{
    public void run()
    {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        Main my=new Main();
        for(int i=0;i<my.n;i++)
        {
            my.a[i]=rand.nextInt(100);
            System.out.println("\nThe Random number is "+my.a[i]);
            try{
                Thread.sleep(1000);

            }
            catch (InterruptedException e){

            }
        }
    }
}
class Runnable2 implements Runnable{
    public void run()
    {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        Main my=new Main();
        for(int i=0;i<my.n;i++)
        {
            //my.a[i]=rand.nextInt(100);
            System.out.println("\nThe Square of Random number is "+(my.a[i]*my.a[i]));

        }
    }
}

class Runnable3 implements Runnable{
    public void run()
    {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        Main my=new Main();
        for(int i=0;i<my.n;i++)
        {
            //my.a[i]=rand.nextInt(100);
            System.out.println("\nThe Cube of Random number is "+(my.a[i]*my.a[i]*my.a[i]));

        }
    }
}
