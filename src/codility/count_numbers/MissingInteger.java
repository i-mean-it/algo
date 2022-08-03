package codility.count_numbers;

public class MissingInteger {
    public static void main(String[] args) {
        //주의해서 풀어야 할 듯
        //Edge case 주의
        //N은 최대 100000개  그럼 만약에 숫자가 마이너스거나 100000을 넘어간다면 체크 할 필요가 없다
        //큰 수는 체크 할 필요할 없는 이유가 그 자리에 대신해서 100000보다 큰 수가 들어갔다면 분명 그보다가 작은 수가 대신 못 들어갔기 때문이다

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = 100000;
        boolean [] checkNums = new boolean[n+1];
        for(int a : A){
            if(a > 0 && a < checkNums.length) checkNums[a] = true;
        }
        for(int i = 1 ; i < checkNums.length; i++){ //checkNums.length 까지 포함하면 100001 index 도 체크 하기 때문에 절대 안 됌
            if(checkNums[i] == false) return i;
        }
        return checkNums.length;
    }
}
