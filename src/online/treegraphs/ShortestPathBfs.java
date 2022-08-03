package online.treegraphs;

import java.util.*;

public class ShortestPathBfs {

    /* 입력값
    #,  v: 6 , e : 9
    6 9
    1 3
    1 4
    2 1
    2 5
    3 4
    4 5
    4 6
    6 2
    6 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i <= v ; i++) adjList.add(new ArrayList<Integer>());
        for(int i = 0; i < e; i++){
            int start = sc.nextInt();
            int dest = sc.nextInt();
            adjList.get(start).add(dest);
        }
        int [] minDis = bfs(adjList, 1);
        for (int i = 1; i < minDis.length; i++) {
            System.out.println("i :" + i + " minDIs[i] = " + minDis[i]);
        }
    }

    static int [] bfs(ArrayList<ArrayList<Integer>> adjList, Integer startNode){
        int [] minDis = new int[adjList.size()];
        boolean [] visited = new boolean[adjList.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int currentNode = q.poll();
            for(Integer i : adjList.get(currentNode)){
                if(!visited[i]){
                    //update min Distance
                    minDis[i] = minDis[currentNode] + 1;
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return  minDis;
    }
}
