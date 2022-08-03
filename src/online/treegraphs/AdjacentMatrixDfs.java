package online.treegraphs;

import java.util.Scanner;

//matrix는 최대한 비추
public class AdjacentMatrixDfs {

    static int [][] adjMatrix;
    static boolean [] visited;
    static int dest;


    /* input
    5 9
    1 2
1 3
1 4
2 1
2
3
2 5
3 4
4 2
4 5
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // # vertices, 정점 수
        int e = sc.nextInt(); //# edges , 간선 수
        dest = v;
        adjMatrix = new int[v+1][v+1];
        visited = new boolean[v+1];
        for(int i = 0; i < e; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            adjMatrix[start][end] = 1;//weight 는 없으니까 걍 1
        }

        visited[1] = true;
        int ans = DFS(1);
        System.out.println("# ways " + ans);

    }

    static int DFS(int v){
        int ways = 0;
        if(v == dest) {
            return 1;
        }
        for(int i = 0; i < adjMatrix.length; i++){
            if(adjMatrix[v][i]  == 1 && !visited[i]){
                visited[i] = true;
                ways += DFS(i);
                visited[i] = false;
            }
        }
        return ways;
    }
}
