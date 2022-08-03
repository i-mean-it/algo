package online.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] array = new int [] {5,3,1,4,2};
        //doSelectionSort(array);
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void doSelectionSort(int [] array){
        int smallestIndex = 0;
        int index = 0;

        while(index < array.length -1) {
            smallestIndex = index;
            for(int i = index+1; i < array.length; i++){
                if(array[smallestIndex] > array[i]){
                    smallestIndex = i;
                }
            }
            //swap
            swap(array, index, smallestIndex);
            index++;
        }
    }

    static void selectionSort(int [] arr){
        for(int i = 1; i < arr.length ; i++){
            int temp = arr[i];
            int j;
            for(j = i-1; j >= 0 ; j--){
                if(arr[j] > temp) arr[j+1] = arr[j];
                else{
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

    static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
