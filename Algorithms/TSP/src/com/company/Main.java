package com.company;
import java.util.*;

public class Main {
    final static int MAX=100;
    final static int INFINITY=999;
    public static int tsp(int c[][],int tour[],int start,int n)
    {
        int i,j,k,mincost,ccost;
        int tem[]=new int[MAX];
        int mt[]=new int[MAX];
        if(start==n-2)
            return (c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0]);
        mincost=INFINITY;
        for(i=start+1;i<n;i++)
        {
            for(j=0;j<n;j++)
                tem[j] = tour[j];
            tem[start + 1] = tour[i];
            tem[i] = tour[start + 1];

            if(c[tour[start]][tour[i]]+(ccost=tsp(c,tem,start+1,n))<mincost)
            {
                mincost=ccost+c[tour[start]][tour[i]];
                for(k=0;k<n;k++)
                    mt[k]=tem[k];
            }

        }
        for(i=0;i<n;i++)
            tour[i]=mt[i];
        tour[i]=start;
        return mincost;
    }

    public static void main(String[] args) {
	// write your code here
        int n,i,j,cost;
        int c[][]=new int[MAX][MAX];
        int tour[]=new int[MAX];
        Scanner sc=new Scanner(System.in);
        System.out.println("ENC");
        n=sc.nextInt();
        System.out.println("ECM");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                c[i][j]=sc.nextInt();
        for(i=0;i<n;i++)
            tour[i]=i;
        cost=tsp(c,tour,0,n);
        System.out.println("\nMCD:" +cost);
        System.out.println("\ntour ");
        for(i=0;i<=n;i++)
            System.out.println(+tour[i]+1 +"\t");
    }
}
