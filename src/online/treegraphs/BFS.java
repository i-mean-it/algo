package online.treegraphs;

import java.util.LinkedList;
import java.util.Queue;



public class BFS {
    static Node root;


    static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            this.data = val;
            lt=rt=null;
        }
    }
    static void doBfs(Node node){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node currentNode = q.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.lt != null) q.add(currentNode.lt);
            if(currentNode.rt != null) q.add(currentNode.rt);
        }

    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        doBfs(root);
    }
}
