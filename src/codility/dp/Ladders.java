package codility.dp;

import java.util.Arrays;

public class Ladders {
    public static void main(String[] args) {
        //([4, 4, 5, 5, 1], [3, 2, 4, 3, 1])    //
        int [] ans = solution( new int []{4, 4, 5, 5, 1}, new int [] {3, 2, 4, 3, 1});
        System.out.println(Arrays.toString(ans)); // [5, 1, 8, 0, 1],
    }

    public static int[] solution2(int[] A, int[] B) {
        int[] ans = new int[A.length];
        long [] dp = new long[50000 + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 50000; i++) {
            dp[i] = (long) ((dp[i-1] % Math.pow(2, 30) + dp[i-2] % Math.pow(2,30)) % Math.pow(2,30));
        }
        for(int i = 0; i < A.length; i++){
            ans[i] = (int) (dp[A[i]] % Math.pow(2, B[i]));
        }
        return ans;
    }

    public static int[] solution(int[] A, int[] B) {
        int[] ans = new int[A.length];
        long [] memo = new long[50000 + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 0; i < A.length; i++) {
            ans[i] = (int)(fibs(A[i], B, memo) % (int) Math.pow(2, B[i]));
        }
        return ans;
    }

    static long fibs(int a, int[] B, long[] memo) {
        if (memo[a] > 0) {
            return memo[a];
        } else {
            return memo[a] = fibs(a - 1, B, memo) + fibs(a - 2, B, memo);
        }
    }
}
