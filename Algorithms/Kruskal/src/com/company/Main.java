package com.company;
import java.util.*;
public class Main {
    public static int find(int v,int s[])
    {
        while(s[v]!=v)
            v=s[v];
        return v;
    }
    public static void union(int i,int j,int s[])
    {
        s[i]=j;
    }
    public static void kruskal(int n,int c[][])
    {
        int min,i,j,u=0,v=0,count=0,sum=0,k=0;
        int s[]=new int[20];
        int t[][]=new int[10][2];
        for(i=0;i<n;i++)
            s[i]=i;
        while(count<n-1){
            min=999;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if((c[i][j]!=0)&&(c[i][j]<min)){
                        min=c[i][j];
                        u=i;
                        v=j;
                    }
                }
            }
            if(min==999)
                break;
            i=find(u,s);
            j=find(v,s);
            if(i!=j)
            {
                t[k][0]=u;
                t[k][1]=v;
                sum+=min;
                count++;
                union(i,j,s);
                k++;

            }
            c[u][v]=c[v][u]=999;
        }
        if(count==n-1)
        {
            System.out.println("Cost of Spanning tree= "+sum+"\n");
            System.out.println("Spanning tree\n");
            for(k=0;k<n-1;k++)
            {
                System.out.println("\n"+t[k][0]+","+t[k][1]);
            }
        }
        else
            System.out.println("Spanning tree doesn't exist\n");


    }

    public static void main(String[] args) {
	// write your code here
        int i,j,n;
        int c[][]=new int[20][20];
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of nodes\n");
        n=in.nextInt();
        System.out.println("Enter the cost adjacency matrix\n");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                c[i][j]=in.nextInt();
            }
        }
        kruskal(n,c);
    }
}
