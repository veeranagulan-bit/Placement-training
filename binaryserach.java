import java.util.Scanner;

public class binaryserach {
    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int target = sc.nextInt();

        int left = 0;
        int right = arr.length - 1;
        int foundIndex = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                foundIndex = mid;
                break;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Number found at index: " + foundIndex);
        } else {
            System.out.println("Number not found in array");
        }
    }
}