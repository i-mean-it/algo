package online.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pick = sc.nextInt();
        printAllCombinations(n, pick,  0, 1, new int[pick]);
    }

    private static void printAllCombinations(int n , int pick,  int count, int index, int[] picks) {
        if(count == pick){
            Arrays.stream(picks).forEach(s -> System.out.print(s  + " "));
            System.out.println();
            return;
        }
        for(int i = index ; i <= n; i++){
            picks[count] = i;
            printAllCombinations(n, pick, count+1, i+1, picks);
        }
    }
}
