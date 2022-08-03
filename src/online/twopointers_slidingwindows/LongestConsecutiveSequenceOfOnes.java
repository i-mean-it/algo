package online.twopointers_slidingwindows;

import java.util.Scanner;

public class LongestConsecutiveSequenceOfOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int k = sc.nextInt();
        int [] array = new int[length];
        for(int i = 0 ; i < length; i++) array[i] = sc.nextInt();
        findLongestConsecutiveSequenceOfOnesWithKChanges(length, k , array);
    }

    private static void findLongestConsecutiveSequenceOfOnesWithKChanges(int length, int k, int[] array) {
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int longestLength = 0;
        while(p2 < array.length){
            if(array[p2] == 0){
                count++;
                if(count > k){
                    longestLength = Math.max(longestLength, p2-p1);
                    //advance p1 until find 0
                    if(array[p1] != 0){
                        while(array[p1] != 0) p1++;
                    }
                    p1++;
                    count--;
                }
            }
            p2++;
        }
        if(count == k && p2 > p1) longestLength = Math.max(longestLength, p2-p1);
        System.out.println(longestLength);

        Character c = 'z';
    }
}
