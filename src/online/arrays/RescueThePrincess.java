package online.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RescueThePrincess {

    //input 8 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int it = sc.nextInt();
        int ans = findTheWinnerQ(n, it);
        System.out.println( ans);

    }

    static int findTheWinnerQ(int n, int it){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n ; i++) q.add(i);
        int count = 1;
        while(q.size() > 1){
            if(count == it){
                q.poll();
                count = 1;
            }else{
                q.add(q.poll());
                count++;
            }
        }
        return q.poll();

    }

    static int findTheWinner(int n , int it){
        int count = 1;
        int winner = -1;
        int left  = n;
        int i = 0;
        boolean [] isOut = new boolean[n];
        while(winner < 0){
            if(!isOut[i%n]){ //in
                if(left > 1) {
                    if(count ==  it) {
                        isOut[i%n] = true;
                        count = 1;
                        left--;
                    }else count++;
                }else winner = (i%n)+1;
            }
            i++;
        }
        return winner;
    }


}
