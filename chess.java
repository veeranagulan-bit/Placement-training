public class chess {

    static int N = 4;
    static int count = 0;

    static boolean[] col = new boolean[N];
    static boolean[] d1 = new boolean[2 * N];
    static boolean[] d2 = new boolean[2 * N];

    static void solve(int r) {

        if (r == N) {
            count++;
            System.out.println("Solution " + count);
            return;
        }

        for (int c = 0; c < N; c++) {

            if (col[c] || d1[r - c + N] || d2[r + c]) {
                continue;
            }

            col[c] = true;
            d1[r - c + N] = true;
            d2[r + c] = true;

            solve(r + 1);

            col[c] = false;
            d1[r - c + N] = false;
            d2[r + c] = false;
        }
    }

    public static void main(String[] args) {

        solve(0);

        System.out.println("Total COUNT = " + count);
    }
}