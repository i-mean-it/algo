package codility.iteration;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(9));
        System.out.println(solution(1041));
        System.out.println(solution(32));
    }

    public static int solution(int N) {
        boolean hasStartingOne = false;
        int zeroCount = 0, maxZeroCount = 0;

        while(N > 0){
            if(N%2 == 1) {
                if(!hasStartingOne) hasStartingOne = true;
                else{
                    maxZeroCount = Math.max(maxZeroCount, zeroCount);
                    zeroCount = 0;
                }
            }else{
                if(hasStartingOne) zeroCount++;
            }
            N /= 2;
        }
        return maxZeroCount;
    }
}
