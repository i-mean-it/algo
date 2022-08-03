package codility.prefixSums;

public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
        System.out.println(solution(0, 11, 2));
        System.out.println(solution(0, 1, 2));
        System.out.println(solution(0, 1, 1));

    }

    public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
        //0 조심 하기 !!!
        int numsDivisibleByKUntilA = A / K + 1;
        int numsDivisibleByKUntilB = B / K + 1;
        return numsDivisibleByKUntilB - numsDivisibleByKUntilA + (A % K == 0 ? 1 : 0);
    }

}
