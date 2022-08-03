package online.dp;

import java.util.Scanner;

public class GetHighestScorePossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numQs = sc.nextInt();
        int timeLimit = sc.nextInt();
        int [] points = new int[numQs];
        int [] mins = new int[numQs];
        for(int i = 0 ; i < numQs; i++){
            points[i] = sc.nextInt();
            mins[i] = sc.nextInt();
        }
        System.out.println(getHighestScorePossible(points, mins, timeLimit,  new int[timeLimit+1]));

    }

    static int getHighestScorePossible(int [] points, int [] mins, int timeRemaining,  int [] dp){
        for(int i = 0 ; i < mins.length; i++){
            for(int t = dp.length-1 ; t >= mins[i]; t--){
                if(dp[t] < dp[t-mins[i]] + points[i] ) dp[t] = dp[t-mins[i]] + points[i];
            }
        }
        return dp[timeRemaining];
    }
}
