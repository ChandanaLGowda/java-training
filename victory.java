package practice;

public class victory {
    public static void printpattern (String ppp) {
        for (int i = 0; i <= 21; i++) {
            System.out.print(ppp);

        }
    }

    public static void main(String[] args) {
        printpattern("/");
        System.out.println("\n || victory is mine||");
        printpattern("\\");
    }

}
