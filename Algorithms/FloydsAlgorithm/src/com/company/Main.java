package com.company;
import java.util.*;

public class Main {
    public static int min(int a,int b){
        if(a<b)
            return a;
        else
            return b;

    }
    public static void floyd(int c[][],int n){
        int i,j,k;
        int d[][]=new int[10][10];
        Scanner in=new Scanner(System.in);
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                d[i][j]=c[i][j];
            }
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                for(k=1;k<=n;k++)
                {
                    d[i][j]=min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                System.out.print(d[i][j]+" ");
            }
            System.out.println("\n");
        }


    }

    public static void main(String[] args) {
        // write your code here
        int c[][]=new int[10][10];
        int n;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the value of n\n");
        n=in.nextInt();
        System.out.println("Enter the cost adjacency matrix\n");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                c[i][j]=in.nextInt();
            }
        }
        floyd(c,n);



    }
}
