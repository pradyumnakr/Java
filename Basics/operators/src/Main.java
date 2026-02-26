public class Main {
    public static void main(String[] args){
        int operator=1+2;
        System.out.println("the result is\n" +operator);
        int previousresult=operator;
        operator=operator+1;
        System.out.println("the new result is\n" +operator);
        int result=3;
        result=result-1;
        System.out.println(result);
        previousresult=result;
        result=result*10;
        System.out.println(previousresult +"*10="+result);
        previousresult=result;
        result=result/5;
        System.out.println(previousresult + "/5 ="+result);
        previousresult=result;
        result=result%3;
        System.out.println(previousresult +"%3="+result);
        result++;
        System.out.println("the result is\n"+result);
        result += 10;
        System.out.println("result\n"+result);
        result *=10;
        System.out.println("result is\n"+result);
        boolean isalien=false;
        if (isalien==false)
        System.out.println("its an alien");
        int topscore=90;
        if (topscore<=100)
            System.out.println("you won the match");
        int secondtopscore=60;
        if (topscore>secondtopscore && topscore<100)
            System.out.println("you won again!!!!!");
        if ((topscore>90) || (secondtopscore<90))
            System.out.println("condition is satisfied");
        double one=20;
        double two=80;
        double sum=one + two;
        System.out.println(sum);
        sum*=25;
        System.out.println(sum);
        sum%=40;
        System.out.println(sum);
        if (sum<=20)
            System.out.println("total was over the limit");

    }
}
