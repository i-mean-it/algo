package online.treegraphs;

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i = 0 ; i < n ; i++) coins[i] = sc.nextInt();
        int amount = sc.nextInt();
        int ans = getMinCoinChange(amount, coins, 0, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    static int getMinCoinChange(int amount, int [] coins, int count, int minCoins){
        if(amount < 0 || count >= minCoins) return -1;
        if(amount == 0) return count;
        if(amount < 0) return -1;
        for(int i = coins.length-1 ; i >=0 ; i--){
            int coinsUsed = getMinCoinChange(amount-coins[i], coins, count+1, minCoins);
            if(coinsUsed >= 0 &&  minCoins > coinsUsed) minCoins = coinsUsed;
        }
        return minCoins;
    }

    /*static int getMinCoinChangeReverse(int amount, int [] coins, int count, int sum){
        if(amount == sum) return count;
        if(sum > amount) return -1;
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length; i++){
            int coinsUsed = getMinCoinChange(amount-coins[i], coins, count+1);
            if(coinsUsed >= 0 &&  minCoins > coinsUsed) minCoins = coinsUsed;
        }
        return minCoins;
    }*/


}
