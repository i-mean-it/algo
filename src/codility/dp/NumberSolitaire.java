package codility.dp;

import java.util.Arrays;

public class NumberSolitaire {
    public static void main(String[] args) {
        int [] arr = {1,-2,0,9,-1,-2};
        int ans = solutionDP(arr);
        Integer [] memo = new Integer[arr.length];
        Arrays.fill(memo, null);
        int ansRe = solveRecursively(arr, memo, 0);
        System.out.println("ans = " + ans);
        System.out.println("ansRe = " + ansRe);
    }

    public static int solutionDP(int[] A) {
        int [] dp = new int[A.length];
        int length = A.length;
        dp[length-1] = A[length-1];
        for(int i = length-2; i >= 0; i--){
            int maxValue = Integer.MIN_VALUE;
            for(int dice = 1; dice <= 6; dice++){
                if(dice + i < length){
                    maxValue = Math.max(maxValue , dp[dice+i]);
                }
            }
            dp[i] = A[i] + maxValue;
            //System.out.println("i:" + i + " dp[i]=" + dp[i]);
        }
        return dp[0];
    }

    public static int solveRecursively(int [] A, Integer [] memo, int index){
        //base case
        if(index >= A.length) return Integer.MIN_VALUE;
        if(index == A.length-1){
           return A[index];
        }else{
            if(memo[index] != null ) return memo[index];
            int maxValue = Integer.MIN_VALUE;
            for(int i = 1; i <= 6; i++){
               maxValue = Math.max(maxValue, solveRecursively(A, memo, index + i ));
            }
            return memo[index] = maxValue + A[index];
        }
    }
}
