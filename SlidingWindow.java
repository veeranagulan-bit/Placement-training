public class SlidingWindow {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60};
        int k = 3;

        int sum = 0;
        int sum1= 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = arr[3]; i < arr.length; i++) {
            sum1 += arr[i];

            if (sum >sum1 ) {
                System.out.println(sum);
            }
            else {
                System.out.println(sum1);
            }
        }

        
    }
}