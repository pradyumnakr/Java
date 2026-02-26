package com.company;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
public class Main {
    public static int findmin(int n,int s[],int d[]){
        int min=0;
        for(int i=1;i<=n;i++){
            if(s[i]==0)
            {
                min=i;
                break;
            }

        }
        for(int i=1;i<=n;i++)
        {
            if((d[i]<d[min])&&(s[i]==0))
            {
                min=i;
            }
        }
        return min;
    }
    public static void dijkstra(int w[][],int s[],int d[],int v,int n){
        int i,j,w1,k,u;
        int p[]=new int[20];
        for(i=1;i<=n;i++)
        {
            s[i]=0;
            d[i]=999;
            p[i]=0;
        }
        d[v]=0;
        for(k=1;k<=n;k++)
        {
            u=findmin(n,s,d);
            s[u]=1;
            for(w1=1;w1<=n;w1++){
                if((w[u][w1]!=999)&&(s[w1]==0))
                {
                    if(d[w1]>d[u]+w[u][w1])
                    {
                        d[w1]=d[u]+w[u][w1];
                        p[w1]=u;
                    }
                }
            }
        }
        System.out.println("The Shortest path costs\n");
        for(i=1;i<=n;i++)
        {
            if(d[i]==999)
                System.out.println("Sorry no path for source "+v+" to"+i+" vertex");
            else
                System.out.println("path cost from "+v+ " to"+i+" is"+d[i]+"\n");
        }
        System.out.println("Shortest group of paths are\n");
        for(i=1;i<=n;i++)
        {
            if((i!=v)&&(d[i]!=999))
            {
                System.out.print(i);
                j=p[i];
                while(p[j]!=0)
                {
                    System.out.println("<-------"+j+" ");
                    j=p[j];
                }
                System.out.println("<-----------"+v+"\n");
            }
        }
    }


    public static void main(String[] args) {
	// write your code here
        int i,j,n,v;
        int d[]=new int[20];
        int s[]=new int[20];
        int w[][]=new int[20][20];
        Main d1=new Main();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of vertices\n");
        n=in.nextInt();
        System.out.println("Enter the cost of vertices\n");
        for(i=1;i<=n;i++) {
            for (j = 1; j <= n; j++) {
                w[i][j] = in.nextInt();
            }
        }
        System.out.println("enter the source vertex\n");
        v=in.nextInt();
        d1.dijkstra(w,s,d,v,n);
    }
}
