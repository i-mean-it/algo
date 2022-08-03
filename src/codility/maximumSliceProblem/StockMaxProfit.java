package codility.maximumSliceProblem;

public class StockMaxProfit {
    public static void main(String[] args) {
        int [] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int [] maxProfits = new int [A.length];
        int maxProfit = 0;
        int max = 0;
        int min = 0;
        for(int i = A.length-1; i >= 0; i--){
            int profit = Math.max(max-A[i],0);
            if(profit > 0) maxProfits[i] = profit;
            maxProfit = Math.max(maxProfit, profit);
            max = Math.max(A[i], max);
        }
        return maxProfit;
    }

}
