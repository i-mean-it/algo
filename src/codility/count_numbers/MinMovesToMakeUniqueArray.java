package codility.count_numbers;

import java.util.ArrayList;

public class MinMovesToMakeUniqueArray {

    public static void main(String[] args) {
        System.out.println(solution(new int []{1,2,1})); //2
        System.out.println(solution(new int []{3,2,3})); //2
        System.out.println(solution(new int []{2,1,4, 4})); //1
        System.out.println(solution(new int []{1,1,1})); //3
        System.out.println(solution(new int []{2,2,2})); //2
        System.out.println(solution(new int []{3,3,3})); //3
        System.out.println(solution(new int []{6,2,3, 5, 6, 3})); //4



    }

    static int solution(int [] a){
        int n = a.length;
        int moves = 0;

        int [] howMany = new int[n+1];
        ArrayList<Integer> need = new ArrayList<>();
        ArrayList<Integer> taken = new ArrayList<>();

        //count how many
        for(Integer i : a){
            howMany[i]++;
        }
        for(int i = 1 ; i < howMany.length; i++){
            if(howMany[i] == 0) need.add(i);
            else if(howMany[i] > 1){
                while(howMany[i] > 1){
                    howMany[i]--;
                    taken.add(i);
                }
            }
            while(!need.isEmpty() && !taken.isEmpty()){
                moves += Math.abs(taken.get(0) - need.get(0));
                taken.remove(0);
                need.remove(0);
            }
        }

        if(moves > 1000000000) return -1;
        return moves;


    }
}
