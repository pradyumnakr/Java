public class Main {
    public static void main(String[] args) {
        int score = calculatescore("tim", 400);
        System.out.println(score + "!!!");
        calculatescore(50);
        double answer = calfeetandinchestocentimeters(-10, 5);
        if (answer < 0.0) {
            System.out.println("invalid parameters");
        } else {
            System.out.println("the answer is " + answer);
        }


    }

    public static int calculatescore(String playername, int score) {
        System.out.println("player " + playername + "scored " + score + " points");
        return score * 20;
    }

    public static int calculatescore(int score) {
        System.out.println("unplayer " + "scored " + score + " points");
        return score * 20;
    }

    public static double calfeetandinchestocentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0 && inches > 12)) {
            System.out.println("invalid!!!!");
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        return centimeters;

    }
    public static double calfeetandinchestocentimeters( double inches){
        if (inches<0)
            return -1;

    }
}
