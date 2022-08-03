package online.dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ;i++){
            arr[i] = sc.nextInt();
        }
        int ans = getLisLength(arr);
        System.out.println(ans);
    }

    private static int getLisLength(int[] arr) {
        int [] dis = new int[arr.length];
        dis[0] = 1;
        int longestDis = 0;
        for(int i = 1; i < arr.length; i++){
            int longestPrevDis = 0;
            for(int b = i-1; b >= 0; b--){
                if(arr[b] < arr[i]){
                    if(dis[b] > longestPrevDis) longestPrevDis = dis[b];
                }
            }
            dis[i] = longestPrevDis + 1;
            if(dis[i] > longestDis) longestDis = dis[i];
        }
        return longestDis;
    }
}
