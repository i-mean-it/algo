package online.strings;

import java.util.Arrays;
import java.util.Scanner;

public class MinDisFromChar {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.next();
        String c = in.next();
        System.out.println("s = " + s);
        System.out.println("c = " + c);
        int [] ans = getMinDistanceFromChar(s,c);
        Arrays.stream(ans).forEach(st -> System.out.print(st + " "));
        return ;
    }

    public static int [] getMinDistanceFromChar(String s, String c){

        int [] arr = new int[s.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i = 0 ; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals(c)) updateDistance( arr, i);
        }
        return arr;
    }

    static void updateDistance(int [] arr, int index){
        //update left
        arr[index] = 0;
        int leftIndex = index-1;
        int rightIndex = index+1;
        int value = 1;
        while(leftIndex >= 0 || rightIndex < arr.length) {
            if(leftIndex >= 0 && arr[leftIndex] > value) arr[leftIndex] = value;
            if(rightIndex < arr.length && arr[rightIndex] > value) arr[rightIndex] = value;
            leftIndex--;
            rightIndex++;
            value++;
        }
    }
}
