package online.twopointers_slidingwindows;

import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int days = in.nextInt();
        int consecutiveDays = in.nextInt();
        int [] arr = new int[days];
        for(int i = 0 ; i < days ; i++) arr[i] = in.nextInt();
        System.out.println(getMaxProfit(arr, consecutiveDays));
        return ;
    }

    static int getMaxProfit(int [] arr, int consecutiveDays){
        int maxProfit = 0;
        int profit = 0;
        for(int i = 0 ; i < consecutiveDays; i++) maxProfit += arr[i];
        profit = maxProfit;
        for(int plus =consecutiveDays; plus < arr.length; plus++){
            profit = profit + arr[plus] - arr[plus-consecutiveDays];
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
}