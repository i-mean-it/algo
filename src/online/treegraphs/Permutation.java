package online.treegraphs;


import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) arr[i] = sc.nextInt();
        printPermutation(arr, new int [r], new boolean[n], r, 0);

    }

    static void printPermutation(int [] arr, int [] memo, boolean [] used, int r, int count){
        if(r == count){
            for(int i = 0 ; i < memo.length; i++){
                System.out.print(memo[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = 0 ; i < arr.length; i++){
                if(used[i] == false){
                    memo[count] = arr[i];
                    used[i] = true;
                    printPermutation(arr, memo, used, r, count+1);
                    used[i] = false;
                }
            }
        }
    }
}
