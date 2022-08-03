package online.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class ClawMachineKakao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] map = new int[n][n];
        //map 만들기
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n ; c++){
                map[r][c] = sc.nextInt();
            }
        }
        int numMoves = sc.nextInt();
        int [] moves = new int[numMoves];
        for(int i = 0; i < numMoves; i++){
            moves[i] =  sc.nextInt();
        }
        int ans = getNumWins(map, moves);
        System.out.println("ans = " + ans);
    }

    static int getNumWins(int[][] map, int [] moves){
        Stack<Integer> s = new Stack<>();
        int [] nextPos = new int[moves.length];
        int wins = 0;
        for(int m = 0 ; m < moves.length; m++){
            int row = -1;
            if(nextPos[moves[m]-1] != 0)  row  = nextPos[moves[m]-1];
            else{
                for(int r = 0 ; r < map.length; r++) {
                    if(map[r][moves[m]-1] != 0){
                        row = r;
                        nextPos[moves[m]-1] = r;
                        break;
                    }
                }
            }
            
            if(row >= 0 && row < map.length) {
                if(!s.isEmpty() && s.peek() == map[row][moves[m]-1]){
                    s.pop();
                    wins += 2;
                }else s.push(map[row][moves[m]-1]);
                //update nextPos 
                nextPos[moves[m]-1]++;
            }
        }
        return wins;
    }



}
