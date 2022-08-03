package online.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChulsooAndHisFriend {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) arr[i] = in.nextInt();
        findChulsooAndHisFriend(arr);
        return ;
    }

    static void findChulsooAndHisFriend(int [] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int [] temp = arr.clone();
        Arrays.sort(temp);
        for(int i = 0 ; i < arr.length; i++){
            if(temp[i] != arr[i]){
                ans.add(i+1);
            }
        }
        ans.stream().forEach(s -> System.out.print(s + " "));
    }


}
