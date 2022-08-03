package online.twopointers_slidingwindows;

import java.util.Scanner;

public class ConsecutiveSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int ans = getWaysToCreateConsecutiveSum(target);
        System.out.println( ans);
         ans = getWaysToCreateConsecutiveSumMathWay2(target);
        System.out.println( ans);
    }

    static int getOneToNSum(int n){
        return n * (n+1) /2;
    }

    static int getWaysToCreateConsecutiveSumMathWay(int target){
        int n = 2;
        int count = 0;
        while(getOneToNSum(n) <= target){
            int left = target-getOneToNSum(n);
            if(left % n == 0) count++;
            n++;
        }
        return count;

    }

    static int getWaysToCreateConsecutiveSumMathWay2(int target){
        int n = 2;
        int count = 0;
        target = target-1;
        while(target > 0){
            target = target-n;
            if(target % n == 0) count++;
            n++;
        }
        return count;
    }

    static int getWaysToCreateConsecutiveSum(int target){
        int sum = 0;
        int p1 = 1;
        int p2 = 1;
        int count = 0;

        while(p1 < target ){
            while(sum < target){
                sum += p2;
                p2++;

            }
            if(sum == target) count++;
            sum -= p1;
            p1++;
        }
        return count;
    }


    static int getWaysToCreateConsecutiveSumSecondTrial(int target){
        int p1 = 1;
        int p2 = 1;
        int sum = 0;
        int count = 0;
        while(p2 < target){
            while(sum < target){
                sum += p2;
                p2++;
            }
            if(sum == target) count++;
            sum -= p1;
            p1++;
        }
        return count;


    }
}
