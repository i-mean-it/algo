package online.greedy;

import java.util.*;

class Node{
    int value;
    int minDistance = Integer.MAX_VALUE;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance){
        this.minDistance = minDistance;
    }
}
class Edge{
    int start;
    int end ;
    int dis;

    public Edge(int start, int end, int dis) {
        this.start = start;
        this.end = end;
        this.dis = dis;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDis() {
        return dis;
    }
}
public class Dijkstra {

    /*
    input :
    6 9
    1 2 12
    1 3 4
    2 1 2
    2 3 5
    2 5 5
    3 4 5
    4 2 2
    4 5 5
    6 4 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for(int i = 0 ; i < numNodes; i++) adjList.add(new ArrayList<Edge>());
        //adjList 완성하기
        for(int i = 0 ; i < numEdges; i++) {
            int start = sc.nextInt();
            int dest = sc.nextInt();
            int dis = sc.nextInt();
            adjList.get(start-1).add(new Edge(start,dest, dis));
        }
        Node [] nodes = new Node[numNodes];
        for(int i = 0 ; i < numNodes; i++){
            nodes[i] = new Node(i+1);
        }
        int startNode = 1;
        nodes[startNode-1].setMinDistance(0);

        getTheShortestPathsForEachNode(nodes, adjList, startNode);
        System.out.println();
        Arrays.stream(nodes).forEach(n -> System.out.print((n.getMinDistance()!= Integer.MAX_VALUE ? n.getMinDistance()  : "impossible" )+ " "));
    }

    private static void getTheShortestPathsForEachNode(Node []  nodes, ArrayList<ArrayList<Edge>> adjList, int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getMinDistance() - o2.getMinDistance();
            }
        });
        pq.offer(nodes[0]);
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            ArrayList<Edge> adjEdges = adjList.get(currentNode.getValue()-1);
            for(int i = 0 ; i < adjEdges.size(); i++){
                Edge adjEdge = adjEdges.get(i);
                Node adjNode = nodes[adjEdges.get(i).getEnd()-1];
                if (adjNode.getMinDistance() > currentNode.getMinDistance() + adjEdge.getDis()) { //update distances of the adjacent node ]
                    //update minDistance of the adjNode
                    adjNode.setMinDistance(currentNode.getMinDistance() + adjEdge.getDis());
                    if(!pq.contains(adjNode))pq.add(adjNode);
                }
            }
        }
    }
}
