public class Main {
    public static void main(String[] args){
        boolean gameover=true;
        int score=90;
        int levelcompleted=10;
        int bonus=5;
         int finalscore1=calculatescore( true,90,levelcompleted,bonus);
        System.out.println("the final score 1 is!!!\n" +finalscore1);

         int finalscore2=calculatescore(true,100,50,10);
        System.out.println("the finalscore 2 is !!\n" +finalscore2);


    }
    public static int calculatescore(boolean gameover,int score,int levelcompleted,int bonus){
        if (gameover){
            int finalscore=score+(levelcompleted*bonus);

            return finalscore;
        }
        return -1;
    }
}
