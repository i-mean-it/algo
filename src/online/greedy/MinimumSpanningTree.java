package online.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
input
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

 */
public class MinimumSpanningTree {
    static int[] groups;

    static class DistanceToNode implements Comparable<DistanceToNode>{
        int node;
        int dis;

        public DistanceToNode(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

        public int getNode() {
            return node;
        }

        public int getDis() {
            return dis;
        }

        @Override
        public int compareTo(DistanceToNode o) {
            return this.getDis() - o.getDis();
        }
    }
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.getCost() - o.getCost();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>(); //prim 용
        for(int i = 0 ; i < v; i++) adjList.add(new ArrayList<Edge>());
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            Edge edge = new Edge(v1, v2, cost);

            edges.add(edge);

            //prim용
            Edge reversedEdge = new Edge(v2, v1, cost);
            adjList.get(v1-1).add(edge);
            adjList.get(v2-1).add(reversedEdge);

            //요기까지
        }
        groups = new int[v + 1];
        for(int i = 1 ; i < groups.length; i++) groups[i] = i;
        int minSpanningTree = getMinSpanningTree(edges);
        System.out.println(minSpanningTree);


        int minSpanningTreePrim = getMinSpanningTreePrim(adjList);
        System.out.println(minSpanningTreePrim);
    }

    private static int getMinSpanningTreePrim(ArrayList<ArrayList<Edge>> adjList) {
        int [] ch = new int[adjList.size()+1];
        int sum = 0;
        PriorityQueue<DistanceToNode> distances = new PriorityQueue<>();
        DistanceToNode initDistance = new DistanceToNode(1, 0);
        distances.offer(initDistance);
        while(!distances.isEmpty()){
            DistanceToNode currentNode  = distances.poll();
            if(ch[currentNode.getNode()] == 0){
                ch[currentNode.getNode()] = 1;
                sum += currentNode.getDis();
                for(int i = 0 ; i < adjList.get(currentNode.getNode()-1).size(); i++){
                    Edge e = adjList.get(currentNode.getNode()-1).get(i);
                    distances.offer(new DistanceToNode(e.getV2(), e.getCost()));
                }
            }
        }
        return sum;
    }

    static int getMinSpanningTree(ArrayList<Edge> edges) {
        int sum = 0;
        Collections.sort(edges);
        for (Edge e : edges) {
            int v1= e.getV1();
            int v2 = e.getV2();
            if(find(v1) != find(v2)) {
                sum += e.getCost();
                union(v1, v2);
            }
        }
        return sum;
    }

    static int find(int v) {
        if (v == groups[v]) return v;
        else return groups[v] = find(groups[v]);
    }

    static void union(int v1, int v2) {
        int group1 = find(v1);
        int group2 = find(v2);
        if (group1 != group2) groups[group1] = group2;
    }


}
