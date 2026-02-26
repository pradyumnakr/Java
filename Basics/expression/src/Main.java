public class Main {
    public static void main(String[] args) {
        int highscore = 50;
        if (highscore == 50)
            System.out.println("you are correct!!!");
        int myvariable = 49;
        myvariable++;
        System.out.println("my " +
                "variable " +
                "is");
        System.out.println(myvariable);
        boolean gameover = true;
        int score = 5000;
        int bonus = 10;
        int levelcompleted = 5;

        if (score < 5000) {
            System.out.println("you completed 5000 points!!!");

        } else {
            System.out.println("got here");
        }
        if (gameover == true) {
            int finalscore = score + (levelcompleted * bonus);
            System.out.println(finalscore);
        }

        boolean newgameover = true;
        int newscore = 10000;
        int newbonus = 8;
        int newlevelcompleted = 200;
        if (newgameover == true) {
            int newfinalscore = newscore + (newlevelcompleted * newbonus);
            System.out.println(newfinalscore);
        }
    }
}
