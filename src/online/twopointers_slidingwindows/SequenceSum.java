package online.twopointers_slidingwindows;

import java.util.Scanner;

public class SequenceSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

        int ans = getNumSequenceSum(arr, target);
        System.out.println("ans = " + ans);
    }
    static int getNumSequenceSum(int [] arr, int target){
        int sum = 0;
        int p1 = 0;
        int p2 = p1;
        int count = 0;

        while(p1 < arr.length){
            if(p1 > 0) sum -= arr[p1-1];
            while(sum < target && p2 < arr.length){
                sum += arr[p2];
                p2++;
            }
            //크거나 같아서 나옴
            if(sum == target) count++;
            p1++;
        }
        return count;
    }

}
