package codility.maximumSliceProblem;

public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2}; //17
        int[] B = {-1, -3, -2, 4, 5, 6, -5, -1}; //15
        int[] C = {-1, -3, -2, -4, -5, -6, -5, -1}; //0
        int[] D = {-1, -3, -2, -4, -5, 6, -5, -1}; // 6
        int[] E = {5, 17, 0, 3}; // 17
        int[] F = {5, 5, 5}; //0
        int[] G = {-8, 10, 20, -5, -7, -4}; //30
        System.out.println(getMaxDoubleSliceSum(A));
        System.out.println(getMaxDoubleSliceSum(B));
        System.out.println(getMaxDoubleSliceSum(C));
        System.out.println(getMaxDoubleSliceSum(D));
        System.out.println(getMaxDoubleSliceSum(E));
        System.out.println(getMaxDoubleSliceSum(F));
        System.out.println(getMaxDoubleSliceSum(G));

    }

    static int getMaxDoubleSliceSum(int [] A){
        int n = A.length;
        int maxSum = 0;
        int [] leftSums = new int[n];
        int [] rightSums = new int[n];

        //fill leftSums
        for(int i = 1; i < n-2; i++){
            leftSums[i] = Math.max(A[i] + leftSums[i-1], A[i]);
        }

        //fill rightSums
        for(int i = n-2; i > 1; i--){
            rightSums[i] = Math.max(A[i] + rightSums[i+1], A[i]);
        }

        //find the y !
        for(int y = 1; y < n-1; y++){
            int sum = Math.max(leftSums[y-1], 0) + Math.max(rightSums[y+1],0);
            maxSum = Math.max(sum , maxSum);
        }
        return maxSum;
    }

    static int getMaxDoubleSliceSum2(int[] A) {
        int n = A.length;
        int leftMaxIndex = 0;
        int rightMaxIndex = 0;
        int totalMaxIndex = 0;
        int totalMaxSum = 0;

        int[] leftSums = new int[n];
        int[] rightSums = new int[n];
        int[] prefixSums = new int[n];

        leftSums[0] = 0;
        rightSums[n - 1] = 0;

        prefixSums[0] = A[0];

        //get left sums && leftMaxSum
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i];
            leftSums[i] = Math.max(A[i - 1] + leftSums[i - 1], 0);
//            leftSums[i] = A[i-1] + (leftSums[i-1] == 0 ? 0 : leftSums[i-1]);
            if (leftSums[i] >= leftSums[leftMaxIndex]) leftMaxIndex = i;
        }

        //get right sums && rightMaxSum
        for (int i = n - 2; i >= 0; i--) {
            rightSums[i] = Math.max(A[i + 1] + rightSums[i + 1], 0);
//            rightSums[i] = A[i+1] + (rightSums[i+1] == 0 ? 0 : rightSums[i+1]);
            if (rightSums[i] >= rightSums[rightMaxIndex]) rightMaxIndex = i;
        }


        //get  total max index

        //nothing in between
        int nothingInBetweenSum = prefixSums[leftMaxIndex - 1] - prefixSums[rightMaxIndex];
        for (int i = rightMaxIndex + 1; i < leftMaxIndex; i++) {
            int total = getTotalMaxSum(i, prefixSums, rightMaxIndex, leftMaxIndex);
            if (total > totalMaxSum) {
                totalMaxSum = total;
            }
        }

        if (hasExtraSpace(rightMaxIndex, leftMaxIndex, n)) return Math.max(nothingInBetweenSum, totalMaxSum);

        return totalMaxSum;
    }

    static int getTotalMaxSum(int index, int[] prefixSums, int rightMaxIndex, int leftMaxIndex) {
        int leftSum = Math.max(prefixSums[index - 1] - prefixSums[rightMaxIndex], 0);
        int rightSum = Math.max(prefixSums[leftMaxIndex - 1] - prefixSums[index], 0);
        return leftSum + rightSum;
    }

    static boolean hasExtraSpace(int rightMaxIndex, int leftMaxIndex, int n) {
        if (rightMaxIndex > 0 || leftMaxIndex < n - 1) return true;
        return false;
    }


}
