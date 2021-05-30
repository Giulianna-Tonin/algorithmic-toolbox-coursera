package week3_greedy;

public class MoneyChange {

//    private static int getChange(int m) {
//        //write your code here
//        return m;
//    }

    //28

    private static int getChange(int m) {
        int tenCoin = 10;
        int fiveCoin = 5;
        int oneCoin = 1;

        int divTen = m/tenCoin;
        int rTen = m%tenCoin;

        if(rTen == 0){
            return divTen;
        }

        int divFive = rTen/fiveCoin;
        int rFive = rTen%fiveCoin;

        if(rFive ==0){
            return divTen + divFive;
        }

        int divOne = rFive/oneCoin;

        return divTen + divFive + divOne;
    }


    public static void main(String[] args) {

//        System.out.println(getChange(28));
        System.out.println(getChange(2));
        System.out.println(getChange(0));
        System.out.println(getChange(1));
        System.out.println(getChange(1000));

    }
}
