package com.company;
import java.util.*;
public class Main {
    static int max=50000;
    public static int partition(int a[],int low,int high){
        int i,j,k,key;
        int temp;
        i=low;
        j=high+1;
        key=a[low];
        while(i<=j){
            do {
                i++;
            }while((key>=a[i])&&(i<=high));
            do {
                j--;
            }while(key<a[j]);
            if(i<j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        return j;

    }
    public static void qsort(int a[],int low,int high)
    {
        int mid;
        if(low<high)
        {
            mid=partition(a,low,high);
            qsort(a,low,mid-1);
            qsort(a,mid+1,high);
        }
    }

    public static void main(String[] args) {
	// write your code here
        int i,j,k;
        int a[]=new int[max];
        int n;
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("Quick sort test\n");
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
            qsort(a,0,n-1);
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
