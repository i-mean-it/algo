package codility.prime_nums_and_factors;

import java.util.ArrayList;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(24)); //8
    }

    static int solution(int N){
        int count = 0;
        for(int i = 1; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                count++;
                if(i < Math.sqrt(N)) count++;
            }
        }
        return count;
    }
}
