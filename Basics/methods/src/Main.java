public class Main {
    public static void main(String[] args){
         int newscore=calculateScore("pady",500);
        System.out.println(newscore);
    }
    public static int calculateScore(String playername,int score){
        System.out.println("'player " + playername+ " scored"+ score + " points");
        return score *100;

    }

    public static int calculateScore(int score){
        System.out.println("'player " +   " scored"+ score + " points");
        return score *100;

    }
    public static double calcFeetAndInchesToCentimeters(double feet,double inches){
        if(  ((feet<=0)||((inches<=0)&&(inches>=12)))
    }

}
