package online.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class BiggerNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int [] array = new int[num];
        int index = 0;
        for(int i = 0; i < num; i++){
            array[i] = in.nextInt();
        }
        for(int n : printBiggerNums(num, array)){
            System.out.print(n + " ");
        }

    }

    static ArrayList<Integer> printBiggerNums(int num , int [] nums){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]) list.add(nums[i]);
        }
        return list;
    }
}
