package codility.sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int [] array = {10, 2, 5, 1, 8, 20};
        int ans = findTriangularTriplet(array);
        System.out.println(ans);
    }

    static int findTriangularTriplet(int [] array){
        Arrays.sort(array);
        for(int i=2; i < array.length ;i++){
            if(array[i] > 0 && array[i-1] > 0 && array[i-2] > 0 ){
                long sum = (long) array[i-1] + (long) array[i-2];
                if(sum > array[i]) return 1;
            }
        }
        return 0;
    }
}
