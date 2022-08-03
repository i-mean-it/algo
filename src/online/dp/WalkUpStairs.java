package online.dp;

import java.util.Scanner;

public class WalkUpStairs {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int [] memo = new int[n+1];
        int ans = walkUpStairs(n, memo);
        int ans2 = walkUpStairsDp(n);
        int ans3 = walkUpStairsDpOpt(n);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
        return ;
    }

    static int walkUpStairs(int n, int [] memo){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(memo[n] > 0) return memo[n];
        return memo[n] = walkUpStairs(n-1, memo) + walkUpStairs(n-2, memo);
    }

    static int walkUpStairsDp(int n){
        int [] paths = new int[n+1];
        paths[0] = 1;
        paths[1] = 1;
        for(int i = 2; i <= n; i++){
            paths[i] = paths[i-1] + paths[i-2];
        }
        return paths[n];
    }

    static int walkUpStairsDpOpt(int n){
        int first = 1;
        int second = 1;
        int ans = 0;
        for(int i = 2; i <= n; i++){
            ans = second + first;
            first = second;
            second = ans;
        }
        return ans;
    }
}
