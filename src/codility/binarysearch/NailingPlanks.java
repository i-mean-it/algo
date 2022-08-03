package codility.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class NailingPlanks {
    //A,B consisting of N integers , C consisting of M integers ... nails !
    public static int solution(int [] A, int [] B, int C[]){
       //the main algorithm is to get the minimal index of nails which is needed to nail every plank
        //by using the binary search

        int numPlanks = A.length;
        int numNails = C.length;

        //two d array to save the original index of array c
        int [][] sortedNail = new int[numNails][2];
        for(int i = 0 ; i < numNails; i++){
            sortedNail[i][0] = C[i];
            sortedNail[i][1] = i;

        }
        Arrays.sort(sortedNail, (int[] x, int[] y) -> x[0]-y[0]);
        int result = 0;

        //find the earliest position that can nail each plank
        //and the max value for all planks is the result ?
        for(int i = 0 ; i < numPlanks; i++){
            result = getMinIndex(A[i], B[i], sortedNail, result);
            if(result == -1) return -1;
        }
        return result + 1;

    }

    //for each plank, we can use binary search to get the minimal index of the
    //sorted array of nails , and we should check the candidate nails to get the
    //minimal index of the original array of nails
    public static int getMinIndex(int startPlank, int endPlank, int [][] nail , int preIndex) {
        int min = 0;
        int max = nail.length - 1;
        int minIndex = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nail[mid][0] < startPlank)
                min = mid + 1;
            else if (nail[mid][0] > endPlank)
                max = mid - 1;
            else {
                max = mid - 1;
                minIndex = mid;
            }
        }
        if (minIndex == -1)
            return -1;

        int minIndexOrigin = nail[minIndex][1];
        //find the smallest original position of the nail that can nail the plank
        for (int i = minIndex; i < nail.length; i++) { //앞에는 이미 안된다고 찾았으니까 minIndex부터만 시작하면 됌 !
            if (nail[i][0] > endPlank) break;
            minIndexOrigin = Math.min(minIndexOrigin, nail[i][1]);
            //we need the maximal index of nails to nail every plank, so the
            //smaller index can be omitted
            if (minIndexOrigin <= preIndex)
                return preIndex;
        }
        return minIndexOrigin;
    }

}
