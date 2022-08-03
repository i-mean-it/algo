package leetcode;

import java.util.Arrays;

//leet code 2037
//https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
public class MinMovesToSeatEveryone {
    public static void main(String[] args) {
        int [] seats = {3,1,5};
        int [] students = {2,7,4};
        minMoveToSeat(seats, students);
    }

    static int minMoveToSeat(int [] seats, int [] students){
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i = 0 ; i < seats.length; i++){
            moves += Math.abs(seats[i]-students[i]);
        }
        return moves;
    }
}
