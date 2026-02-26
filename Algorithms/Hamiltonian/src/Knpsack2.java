import java.util.Scanner;

public class Knpsack2 {
    public static void knapsack(int n,int item[],float weight[],float profit[],float capacity)
    {
        float tp=0;int i;
        float u = capacity;
        float x[]=new float[20];
        for(i=0;i<n;i++)
        {
            if(weight[i]>u)
                break;
            else
            {
                x[i]=(float)1.0;
                tp=tp+profit[i];
                u=(int)(u-weight[i]);
            }
        }
        if(i<n)
            x[i]=u/weight[i];
        tp=tp+(x[i]*profit[i]);
        System.out.println("The resultant vector is ");
        for(i=0;i<n;i++)
            System.out.println("\t Item "+item[i]+" : "+x[i]);
        System.out.println("\n Max profit : "+ tp);
    }
    public static void main(String[] args)
    {
        float weight[]=new float[20];
        float profit[]=new float[20];
        float capacity;
        int n,i,j;
        float ratio[] = new float[20];
        float temp;
        int item[]=new int[20];
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the number of items");
        n=in.nextInt();
        System.out.println("\nEnter the item,wt,and profits");
        for(i=0;i<n;i++)
        {
            item[i]=in.nextInt();
            weight[i]=in.nextFloat();
            profit[i]=in.nextFloat();
        }
        System.out.println("\nEnter knapsack capacity");
        capacity=in.nextFloat();
        for(i=0;i<n;i++)
            ratio[i]=profit[i]/weight[i];
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(ratio[i]<ratio[j])
                {
                    temp = ratio[j];
                    ratio[j]=ratio[i];
                    ratio[i]=temp;

                    temp = profit[j];
                    profit[j]=profit[i];
                    profit[i]=temp;

                    temp = weight[j];
                    weight[j]=weight[i];
                    weight[i]=temp;

                    temp = item[j];
                    item[j]=item[i];
                    item[i]=(int)temp;
                }
            }
        }
        knapsack(n,item,weight,profit,capacity);
    }
}
