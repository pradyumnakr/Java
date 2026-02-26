package com.company;
import java.util.*;
public class Main {
    private static int w[]=new int[20];
    private static int b[]=new int[20];
    private static int v[][]=new int [20][20];
    private static int value[]=new int[20];
    public static int max(int a,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    public static int knap(int i,int j){
        if(i==0||j==0)
            v[i][j]=0;
        else if(j<w[i])
            v[i][j]=knap(i-1,j);
        else
            v[i][j]=max(knap(i-1,j),value[i]+knap(i-1,j-w[i]));
        return v[i][j];
    }
    public static void optimal(int i,int j)
    {
        if(i>=1||j>=1)
            if(v[i][j]!=v[i-1][j])
            {
                System.out.println("Item "+i);
                b[i]=1;
                j=j-w[i];
                optimal(i-1,j);
            }
            else
                optimal(i-1,j);
    }

    public static void main(String[] args) {
	// write your code here
        int n,i,j,profit,capacity;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of items\n");
        n=sc.nextInt();
        System.out.println("Enter the capacity\n");
        capacity=sc.nextInt();
        System.out.println("Enter the values\n");
        for(i=1;i<=n;i++)
            value[i]=sc.nextInt();
        System.out.println("Enter the Weights\n");
        for(i=1;i<=n;i++)
            w[i]=sc.nextInt();
        profit=knap(n,capacity);
        System.out.println("PROFIT: "+profit);
        System.out.println("Optimal subset is\n");
        optimal(n,capacity);
        System.out.println("The solution vector is\n");
        for(i=1;i<=n;i++)
            System.out.println(b[i]);
    }
}
