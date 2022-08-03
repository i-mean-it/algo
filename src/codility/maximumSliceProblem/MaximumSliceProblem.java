package codility.maximumSliceProblem;

public class MaximumSliceProblem {
    public static void main(String[] args) {
        int [] a = {5, -7, 3, 5, -2, 4, -1};
        System.out.println(solution(a));
    }

    public static int solution(int [] a){
        int [] maxSums = new int[a.length];
        maxSums[0] = a[0];
        Integer maxSum = maxSums[0];
        for(int i = 1 ; i < a.length; i++){
            maxSums[i] = Math.max(maxSums[i-1] + a[i] , a[i]);
            maxSum = Math.max(maxSums[i], maxSum);
        }
        return maxSum;
    }
}
