package com.company;
import java.util.*;
public class Main {
    int top,size;
    int stack[];
    Main(int arraysize){
        size=arraysize;
        top=-1;
        stack=new int[size];
    }
    public void push(int value)
    {
        if(top==size-1)
        {
            System.out.println("Stack is full\n");
        }
        else
        {
            top+=1;
            stack[top]=value;
        }
    }
    public int pop()
    {
        int t=0;
        if(top==-1)
        {
            System.out.println("Stack is empty\n");
            return -1;
        }
        else
        {
            t=stack[top];
            top--;
            return t;
        }
    }
    public void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(stack[i]+" ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
	// write your code here
        int i,n;
        Scanner in =new Scanner(System.in);
        System.out.println("Stack operations\n");
        System.out.println("Enter the Size of Stack\n");
        n=in.nextInt();
        Main stk=new Main(n);
        int choice,ch;
        do{
            System.out.println("Stack Operations\n");
            System.out.println("\n\t1:Push\n\t2:Pop\n\t3:Display\n\tENTER YOUR CHOICE\n");
            ch=in.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the element");
                    stk.push(in.nextInt());
                    break;

                case 2:int s=stk.pop();
                        if(s!=-1){
                            System.out.println("The popped Element is "+s);
                        }
                        break;
                case 3:stk.display();
                        break;

            }
            System.out.println("Do you want to continue press 0/1\n");
            choice=in.nextInt();
        }while(choice==1);
    }
}
