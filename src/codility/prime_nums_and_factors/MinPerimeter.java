package codility.prime_nums_and_factors;

public class MinPerimeter {
    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static int solution(int N) {
        int minPerimeter  = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                int otherSide = N/i;
                minPerimeter = Math.min(otherSide+i, minPerimeter);
            }
        }
        return minPerimeter*2;
    }
}
