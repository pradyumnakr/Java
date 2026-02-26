package com.company;
import java.util.*;
public class Main {
    public static void knapsack(int n,int item[],float profit[],float weight[],float capacity)
    {
        float u,tp=0;
        int i;
        u=capacity;
        float x[]=new float[20];
        for(i=0;i<n;i++)
            x[i]=(float)0.0;
        for(i=0;i<n;i++)
        {
            if(weight[i]>u)
                break;
            else{
                x[i]=(float)1.0;
                tp=tp+profit[i];
                u=(int)(u-weight[i]);

            }
        }
        if(i<n)
            x[i]=u/weight[i];
        tp=tp+(x[i]*profit[i]);
        System.out.println("The resultant vector is\n");
        for(i=0;i<n;i++)
            System.out.println("\tItem "+item[i]+": "+x[i]);
        System.out.println("\nProfit is: "+tp);
    }

    public static void main(String[] args) {
	// write your code here
        float weight[]=new float[20];
        float profit[]=new float[10];
        float ratio[]=new float[20],temp;
        int item[]=new int[10];
        int i,j,num;
        float capacity;
        Scanner in=new Scanner(System.in);
        System.out.println("\n Enter the number of objects\n");
        num=in.nextInt();
        System.out.println("\nEnter the item ,weight and profit");
        for(i=0;i<num;i++)
        {
            item[i]=in.nextInt();
            weight[i]=in.nextFloat();
            profit[i]=in.nextFloat();
        }
        System.out.println("Enter the capacity of knapsack\n");
        capacity=in.nextFloat();
        for(i=0;i<num;i++)
        {
            ratio[i]=profit[i]/weight[i];
        }
        for(i=0;i<num;i++)
        {
            for(j=i+1;j<num;j++)
            {
                if(ratio[i]<ratio[j])
                {
                    temp=ratio[j];
                    ratio[j]=ratio[i];
                    ratio[i]=temp;

                    temp=weight[j];
                    weight[j]=weight[i];
                    weight[i]=temp;

                    temp=profit[j];
                    profit[j]=profit[i];
                    profit[i]=temp;

                    temp=item[j];
                    item[j]=item[i];
                    item[i]=(int)temp;
                }
            }
        }
        knapsack(num,item,profit,weight,capacity);
    }
}
