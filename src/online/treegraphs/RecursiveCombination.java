package online.treegraphs;

import java.util.Scanner;

public class RecursiveCombination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int combination = getCombination(n, r);
        System.out.println("combination = " + combination);
    }
    static int getCombination(int n , int r){
        int [][] memo = new int[n+1][r+1];
        return getCombination(n,r,memo);
    }
    static int getCombination(int n ,int r ,int [][] memo){
        if(n == 0 || n < r) return 0;
        else if(r == 0 || r == n) return 1;
        else if (r == 1) return n;
        else if(memo[n][r] > 0) return memo[n][r];
        else return  memo[n][r] = getCombination(n-1,r-1) + getCombination(n-1,r);
    }
}
