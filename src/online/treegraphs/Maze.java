package online.treegraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] map = new int[7][7];
        for(int r = 0 ; r < 7; r++){
            for (int c = 0 ; c < 7; c++){
                map[r][c] = sc.nextInt();
            }
        }
//        int ans = getNumPaths(map, 0, 0);
//        System.out.println("ans = " + ans);
        int ans = getShortestPathDistance(map);
        System.out.println(ans);

    }

    static int getNumPaths(int [][] map, int r, int c ){
        int ans = 0;
        if(r < 0 || c < 0 || r > 6 || c > 6) return 0;
        if(r==6 && c ==6){
            return 1;
        }
        if(map[r][c] == 1 || map[r][c] == -1) return 0; //갈 길 없음
        map[r][c] = -1; // can't visit again
        ans += getNumPaths(map, r-1, c);
        ans += getNumPaths(map, r, c-1);
        ans += getNumPaths(map, r+1, c);
        ans += getNumPaths(map, r, c+1);
        map[r][c] = 0;
        return ans;
    }

    static int getShortestPathDistance(int [][] map ){
        int [][] distances = new int[map.length][map.length];
        int [] rowMove = {0, 0, +1, -1};
        int [] colMove = {+1, -1, 0, -0};
        Queue<Position> q = new LinkedList();
        Position start = new Position(0,0);
        q.add(start);
        while(!q.isEmpty()){
            Position currentPos = q.poll();
            int row = currentPos.getRow();
            int col = currentPos.getCol();
            if(row == 6 && col == 6) return distances[row][col];
            map[row][col] = -1;
            for(int i = 0 ; i < 4; i++){
                int nextRow = rowMove[i] + row;
                int nextCol =  colMove[i] + col;
                if(nextRow < 0 || nextCol < 0 || nextRow > 6 || nextCol > 6) continue;
                if(map[nextRow][nextCol] == 0){
                    distances[nextRow][nextCol]  = distances[row][col] +1;
                    q.add(new Position(nextRow, nextCol));
                }
            }
        }
        return -1;
    }

    static class Position{
        int row ;
        int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
