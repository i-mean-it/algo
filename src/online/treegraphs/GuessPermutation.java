package online.treegraphs;

import java.util.Arrays;
import java.util.Scanner;

public class GuessPermutation {
    //input 4 16
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        getPermutation(n, target);
    }

    private static void getPermutation(int n, int target) {
        //init combinations
        int [] combinations = new int[n];
        boolean [] visited = new boolean[n];
        int [] permutation = new int[n];
        for(int i = 0 ; i < n; i++){
            combinations[i] = getCombination(n-1, i);
        }
        getPermutation(n, target,  0, combinations, visited, permutation);
    }

    private static boolean getPermutation(int n,int target,  int count,  int[] combinations, boolean[] visited, int[] permutation) {
        if(n==count){
            int sum = 0;
            for(int i = 0 ; i < n; i++){
                sum += combinations[i] * permutation[i];
            }
            if(sum == target){
                Arrays.stream(permutation).forEach(s -> System.out.print(s + " "));
                return true;
            }
        }else{
            for(int i = 0 ; i < n; i++){
                if(!visited[i]) {
                    permutation[count] = i+1;
                    visited[i] = true;
                    boolean found = getPermutation(n, target, count+1, combinations, visited, permutation);
                    if(found) return true;
                    visited[i] = false;
                }

            }
        }
        return false;
    }

    static int getCombination(int n ,int r){
        int [][] memo = new int [n+1][r+1];
        return getCombination(n, r , memo);
    }

    private static int getCombination(int n, int r, int[][] memo) {
        //nCr = n-1Cr-1 + n-1Cr
        if(r==0 || r==n) return 1;
        if(r==1) return n;
        return memo[n][r] = getCombination(n-1, r-1, memo) + getCombination(n-1, r);
    }
}
