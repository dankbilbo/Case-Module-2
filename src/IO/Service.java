package IO;
import java.util.Scanner;

public class Service {
    static Scanner sc = new Scanner(System.in);

    public static String inputString(String message) {
        System.out.println(message);
        String inputString = sc.nextLine();
        return inputString;
    }

    public static String inputString() {
        String inputString = sc.nextLine();
        return inputString;
    }

    public static int inputNumber(String message) {
        System.out.println(message);
        int inputNumber = Integer.parseInt(sc.nextLine());
        return inputNumber;
    }

    public static int inputNumber() {
        int inputNumber = Integer.parseInt(sc.nextLine());
        return inputNumber;
    }
}
