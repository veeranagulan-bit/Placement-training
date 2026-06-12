public class PrimeFactor {

    public static void main(String[] args) {

        int num = 12;
        int count = 0;

        for (int i = 2; i <= num; i++) {

            if (num % i == 0) {
                count++;
            }
        }

        if (count == 2) {

            System.out.println(num + " is a Prime Number");

        } else {

            System.out.println(num + " is Not a Prime Number");
            System.out.println("Factors are:");

            for (int i = 2; i <= num; i++) {

                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}