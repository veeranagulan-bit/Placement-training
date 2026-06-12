public class coin {
    public static void main(String[] args) {

        int[] coins = {10, 5, 2, 1};
        int amount = 28;

        int totalCoins = 0;

        System.out.println("Amount = " + amount);

        for (int coin : coins) {
            

            int count = amount / coin;

            if (count > 0) {
                System.out.println(coin + " coin = " + count);

                totalCoins += count;
                amount = amount % coin;
            }
        }

        System.out.println("Minimum coins required = " + totalCoins);
    }
}