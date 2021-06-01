package week5_dynamic_one;

public class MoneyChangeDP {

    private static int getChange(int money) {
        int[] minNumCoins = new int[money + 1];
        int[] coins = {1, 3, 4};

        for (int m = 1; m <= money; m++) {
            minNumCoins[m] = m;

            for (int coin : coins) {
                if (m >= coin) {
                    int minNumCoinInMMinusCoinPos = minNumCoins[m - coin];
                    int numCoins = minNumCoinInMMinusCoinPos  + 1;
                    if (numCoins < minNumCoins[m]) {
                        minNumCoins[m] = numCoins;
                    }
                }
            }
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {

        int money = 34;
        int money3 = 9;
        int money4 = 1000;

        System.out.println(getChange(money3));

    }


}
