package online.treegraphs;


import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static int totalSum = 0;
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6, 7, 10};
        int [] arr2 = {3, 6, 13, 11, 7, 16, 34,23,12};
        totalSum = Arrays.stream(arr2).sum();
        if(totalSum % 2 == 1 ) System.out.println("false");
        else System.out.println(findSubset(arr2, 0, 0));
    }

    static boolean findSubset(int [] arr , int index, int sum){
        if(sum == (totalSum/2)) {
            return true;
        }
        else if(index >= arr.length || sum > (totalSum/2)) return false;
        else{
            return findSubset(arr, index +1 , sum + arr[index]) || findSubset(arr, index +1, sum);
        }
    }
}
