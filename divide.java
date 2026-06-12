public class divide {

    int div() {
        int[] arr = {20, 30, 40, 50};
        int target = 69;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {
                lo = mid + 1;
            }

            else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        divide d1 = new divide();

        int result = d1.div();

        System.out.println("Index = " + result);
    }
}