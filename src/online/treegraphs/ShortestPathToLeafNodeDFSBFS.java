package online.treegraphs;


import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToLeafNodeDFSBFS {

     static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println("level = " + dfs(0, root));
        System.out.println("level = " + bfs(root));

    }

    static int dfs(int level, Node node){
        if(node.lt == null && node.rt == null) return level;
        else return Math.min(dfs(level+1, node.lt), dfs(level+1, node.rt));
    }

    static int bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int levelNodeNums = q.size();
            for(int i = 0; i  < levelNodeNums; i++){
                Node currentNode = q.poll();
                if(currentNode.lt == null && currentNode.rt == null) return level;
                if(currentNode.lt != null) q.offer(currentNode.lt);
                if(currentNode.rt != null) q.offer(currentNode.rt);
            }
            level++;
        }
        return -1;
    }
}
