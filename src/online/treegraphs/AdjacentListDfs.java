package online.treegraphs;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentListDfs {

     /* input
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

        boolean [] visited = new boolean[v+1];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <v+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < e; i++){
            int start = sc.nextInt();
            adjList.get(start).add(sc.nextInt());
        }

        System.out.println("# ways = " + dfs(adjList, 1, v, visited));



    }

    static int dfs(ArrayList<ArrayList<Integer>> adjList, int node, int endNode, boolean [] visited){
        int ways = 0;
        visited[node] = true;

        if(node == endNode){
            return 1;
        }


        for(int i = 0 ; i < adjList.get(node).size(); i++){
            int nextNode = adjList.get(node).get(i);
            if(!visited[nextNode]){
                visited[nextNode] = true;
                ways += dfs(adjList,nextNode, endNode, visited);
                visited[nextNode] = false;
            }

        }
        return ways;
    }
}
