package online.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int num = in.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) arr[i] = in.nextInt();
        System.out.println(binarySearch(arr, num));
        return ;
    }

    static int binarySearch(int [] arr, int num){
        Arrays.sort(arr);
        int start = 0 ; int end = arr.length;
        while(start <= end){
            int mid = (start + end) /2;
            if(arr[mid] == num) return mid+1;
            else if(num < arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
