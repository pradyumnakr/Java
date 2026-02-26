package com.company;
import java.util.*;

public class Main {
    private static int d,count;
    private static int x[]=new int[20];
    private static int w[]=new int[20];
    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int n,sum=0,i,j;
        System.out.println("Enter the number of elements\n");
        n=sc.nextInt();
        System.out.println("Enter the elements in ascending order\n");
        for(i=0;i<n;i++)
        {
            w[i]=sc.nextInt();
        }
        System.out.println("Enter the sum\n");
        d=sc.nextInt();
        for(i=0;i<n;i++)
        {
            sum=sum+w[i];
        }
        if(sum<d)
        {
            System.out.println("Solution is not possible\n");
            return;
        }
        subset(0,0,sum);
    }
    public static void subset(int cs,int k,int r)
    {
        int i;
        x[k]=1;
        if(cs+w[k]==d)
        {
            System.out.println("\nSubset "+(++count));
            for(i=0;i<=k;i++) {
                if (x[i] == 1) {
                    System.out.println(w[i] + " ");
                }
            }
        }
        else if(cs+w[k]+w[k+1]<=d)
            subset((cs+w[k]),k+1,r-w[k]);
        if((cs+r-w[k]>=d )&& (cs+w[k]<=d))
        {
            x[k]=0;
            subset(cs,k+1,r-w[k]);
        }
    }
}
