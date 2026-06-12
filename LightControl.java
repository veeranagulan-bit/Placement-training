import java.util.Scanner;

public class LightControl {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current light state  ");
        int light = sc.nextInt();

        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                if (light == 0 || light != 1) {
                    System.out.println("Light is ON");
                }
                break;

            case 2:
                if (light == 1 && light != 0) {
                    System.out.println("Light is OFF");
                }
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}