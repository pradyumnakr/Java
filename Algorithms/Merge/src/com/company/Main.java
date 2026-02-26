package com.company;
import java.util.*;
public class Main {
    private static int max=50000;
    private static int c[]=new int[100];
    public static void mergesort(int a[],int low,int high){
        int mid;
        if(low<high)
        {
            mid=(low+high)/2;
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }

    }
    public static void merge(int a[],int low,int mid,int high){
        int i,j,k,key;
        i=low;
        j=mid+1;
        k=low;
        //int c[]=new int[100];
        while(i<=mid&&j<=high)
        {
            if(a[i]<=a[j])
            {
                c[k]=a[i];
                i++;
            }
            else
            {
                c[k]=a[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            c[k++]=a[i++];
        }
        while(j<=high)
        {
            c[k++]=a[j++];
        }
        for(i=low;i<=high;i++)
        {
            a[i]=c[i];
        }
    }


    public static void main(String[] args) {
	// write your code here
        int i,j,k;
        int a[]=new int[max];
        int n;
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("Merge sort test\n");
        System.out.println("Enter the number of elements\n");
        n=in.nextInt();
        try{
            for(i=0;i<n;i++)
            {
                a[i]=rand.nextInt(50);

            }
            System.out.println("The random numbers are\n");
            for(i=0;i<n;i++)
            {
                System.out.println(a[i]+" ");
            }
            long st=System.nanoTime();
            mergesort(a,0,n-1);
            long et=System.nanoTime();
            System.out.println("The elements after sorting are\n");
            for(i=0;i<n;i++)
            {
                System.out.println(a[i]+" ");
            }
            long t=et-st;
            System.out.println("Time taken for execution is "+t+" nanoseconds");
        }
        catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("Array index reached maximum");
        }

    }
}
