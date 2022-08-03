package codility.count_numbers;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int [] A = {3,4,4,6,1,4};
        solution(N, A);
    }

    public static  int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int [] ans = new int[N];
        int maxValue = 0;
        int base = 0;
        for(int i = 0 ; i < A.length; i++){
            if(A[i] >= 1 && A[i] <= N){
                if(ans[A[i]-1] < base) ans[A[i]-1] = base;
                ans[A[i]-1]++;
                if(ans[A[i]-1] > maxValue) maxValue = ans[A[i]-1];
            }else if(A[i] == N+1){
                base = maxValue;
            }
        }
        for(int i = 0; i < ans.length; i++){
            if(ans[i] < base) ans[i] = base;
        }
        return ans;
    }
}
