package online.treegraphs;


import java.util.Scanner;

public class Island {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        int ans = getNumIslands(map);
        System.out.println( ans);
    }

    static int getNumIslands(int [][] map){
        int ans = 0;
        for(int r=0; r < map.length; r++){
            for(int c=0; c < map.length; c++){
                if(map[r][c] == 1){
                    if(getNumIslands(map, r, c) > 0) ans++;
                }
            }
        }
        return ans;
    }

    static int getNumIslands(int[][] map, int row, int col) {
        if(row < 0 || col < 0 || row >= map.length || col >= map.length) return 0;
        if (map[row][col] != 1) return 0; //base case : bada ~~
        else {
            int ans = 1 ;
            map[row][col] = -1; //visited
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    if (r != 0 || c != 0) {
                        ans += getNumIslands(map, row+r, col+c);
                    }
                }
            }
            return ans;
        }
    }
}
