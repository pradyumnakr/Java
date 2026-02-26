public class Main {
    public static void main(String[] args){
        int value=1;
        if(value==1){
            System.out.println("it is 1");

        }
        else if(value==2){
            System.out.println("it is 2");
        }
        else{
            System.out.println("neither 1 nor 2");
        }
        int switchvalue=1;
        switch (switchvalue){
            case 1:
                System.out.println("it is 1");
                break;
            case 2:
                System.out.println("it is 2");
                break;
                default:
                    System.out.println("neither 1 nor 2");
                    break;
        }
        char avalue='a';
        switch (avalue){
            case 'a':
                System.out.println("it is a");
                break;
            case 'b':
                System.out.println("it is b");
                break;
            case 'c':
                System.out.println("it is c");
                break;
            case 'd':
                System.out.println("it is d");
                break;
            case 'e':
                System.out.println("it is e");
                break;
                default:
                    System.out.println("none of the above");
        }
    }
}
