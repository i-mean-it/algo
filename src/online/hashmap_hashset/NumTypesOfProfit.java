package online.hashmap_hashset;


import java.util.HashMap;
import java.util.Scanner;

public class NumTypesOfProfit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++)  arr[i] = sc.nextInt();
        getNumTypesOfProfit(arr, k);
    }

    static void getNumTypesOfProfit(int [] arr, int k){

        HashMap<Integer, Integer> profitTypes = new HashMap<>();
        for(int i = 0 ; i < k; i++){
            profitTypes.put(arr[i] , profitTypes.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(profitTypes.size() + " ");

        for(int i = 0 ; i < arr.length - k; i++){
            if(profitTypes.get(arr[i]) > 1)
                profitTypes.replace(arr[i], profitTypes.get(arr[i]) -1);
            else profitTypes.remove(arr[i]);
            profitTypes.put(arr[i+k] , profitTypes.getOrDefault(arr[i+k], 0) + 1);
            System.out.print(profitTypes.size() + " ");
        }
    }




}
