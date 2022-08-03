package online.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinTypes = sc.nextInt();
        int [] coins = new int[coinTypes];
        for(int i = 0 ; i < coinTypes; i++){
            coins[i] = sc.nextInt();
        }
        int change = sc.nextInt();
        System.out.println(solveLeastCoinChangeProblem(coins, change,  new int[change+1]));
        System.out.println(solveLeastCoinChangeProblemDP(coins,change));
        System.out.println(solveLeastCoinChangeProblemDP2(coins,change));
        
    }

    private static int solveLeastCoinChangeProblem(int[] coins,int change, int [] memo) {
        int minCount = Integer.MAX_VALUE;
        if(change  < 0){
            return Integer.MAX_VALUE;
        }
        if(change == 0){
            return 0;
        }
        if(memo[change] > 0) {
            return memo[change];
        }

        for(int i = coins.length-1 ; i >= 0; i--){
            int temp = solveLeastCoinChangeProblem(coins, change-coins[i], memo);
            minCount = Math.min(minCount, temp);
        }
        return memo[change] = minCount+1;
    }

    private static int solveLeastCoinChangeProblemDP(int[] coins,int change) {
        int [] memo = new int[change+1];
        for(int i = 1 ; i < memo.length; i++){
            int minCount  = Integer.MAX_VALUE;
            for(int c = 0 ; c < coins.length; c++){
                int count  = Integer.MAX_VALUE;
                int amountRemaining = i - coins[c];

                if(amountRemaining == 0) count = 0;
                else if(amountRemaining < 0 ) continue;
                else if(memo[amountRemaining] > 0) count = memo[amountRemaining];
                minCount = Math.min(minCount, count);
            }
            memo[i] = minCount;
            if(minCount < Integer.MAX_VALUE) memo[i]++;
        }
        return memo[change];
    }

    public static int  solveLeastCoinChangeProblemDP2(int[] coins,int change){
        int [] memo = new int[change+1];
        Arrays.fill(memo , Integer.MAX_VALUE);
        memo[0] = 0;
        for(int c = 0 ; c < coins.length; c++){
            for(int i = coins[c] ; i <= change; i++){
                memo[i] = Math.min(memo[i], memo[i-coins[c]]+1);
            }
        }
        return memo[change];
    }


//

}
