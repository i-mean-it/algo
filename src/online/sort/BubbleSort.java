package online.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array = new int [] {5,3,1,4,2};
        doBubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void doBubbleSort(int [] array){
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }

    static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
