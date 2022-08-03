package online.arrays;

import java.util.Scanner;

public class Bingo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int [n][n];
        for(int r=0; r < n ; r++){
            for(int c = 0 ; c < n; c++){
                arr[r][c] = sc.nextInt();
            }
        }
        System.out.println(biggestBingo(arr));
        return ;
    }

    static int biggestBingo(int [][] arr){
        return Math.max(horizontalVerticalSumMax(arr), crossSumMax(arr));
    }



    static int horizontalVerticalSumMax(int [][] arr){
        int maxSum = 0;
        for(int r = 0; r < arr.length; r++){
            int sum = 0;
            int sum2 = 0;
            for(int c = 0 ; c < arr.length; c++){
                sum += arr[r][c];
                sum2+= arr[c][r];     //vertical도 같이 하려면 sum += arr[c][r];
            }

            if(sum > maxSum) maxSum = sum;
            if(sum2 > maxSum) maxSum = sum2;
        }
        return maxSum;
    }

    static int verticalSumMax(int [][] arr){
        int maxSum = 0;
        for(int c = 0 ; c < arr.length; c++){
            int sum = 0;
            for(int r = 0; r < arr.length; r++){
                sum += arr[r][c];
            }
            if(sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }

    static int crossSumMax(int [][] arr){
        int rightCrossSum = 0;
        int leftCrossSum = 0;

        //right cross -> cross heading to the right(top to bottom)
        for(int i = 0 ; i < arr.length; i++){
            rightCrossSum += arr[i][i];
            leftCrossSum += arr[i][arr.length-i-1];
        }

        return Math.max(rightCrossSum, leftCrossSum);
    }


}
