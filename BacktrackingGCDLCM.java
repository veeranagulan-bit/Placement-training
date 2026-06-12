public class BacktrackingGCDLCM {

    static void findPairs(int[] arr, int start, int count,
                          int first, int second) {

        // When 2 numbers are selected
        if (count == 2) {

            int g = gcd(first, second);
            int l = lcm(first, second);

            System.out.println("Pair: " + first + ", " + second);
            System.out.println("GCD = " + g);
            System.out.println("LCM = " + l);
            System.out.println();

            return;
        }

        // Backtracking
        for (int i = start; i < arr.length; i++) {

            if (count == 0) {
                findPairs(arr, i + 1, 1, arr[i], 0);
            } else {
                findPairs(arr, i + 1, 2, first, arr[i]);
            }
        }
    }

    // GCD using Euclidean Algorithm
    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    // LCM using GCD
    static int lcm(int a, int b) {

        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 6};

        findPairs(arr, 0, 0, 0, 0);
    }
}