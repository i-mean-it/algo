package codility.leaders;

import java.util.Stack;

public class Dominator {
    public static void main(String[] args) {
        int [] arr = {3,4,3,2,3,-1,3,3};
        findDominator(arr);
    }

    static int findDominator(int [] arr){
        int size = 0, val = 0, count = 0,  candidate = -1, pos = -1;
        for(int i = 0; i < arr.length; i++){
            if(size == 0){
                val = arr[i];
                size++;
            }else{
                if(arr[i] != val) size--;
                else size++;
            }
        }
        if(size > 0) candidate = val;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == candidate){
                pos = i;
                count++;
            }
        }
        if(count > arr.length/2) return pos;
        else return -1;
    }
}
