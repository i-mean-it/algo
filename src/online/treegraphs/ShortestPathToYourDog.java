package online.treegraphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class ShortestPathToYourDog {

    public static void main(String[] args) {
        System.out.println(shortestPath(5,14));
    }

    static int shortestPath(int s, int e){
        int [] distances = {1, -1, 5};
        int [] ch; // check if visited
        Queue<Integer> q = new LinkedList<>();

        ch = new int[10001];
        ch[s] = 1; //starting position
        q.offer(s);
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i < len; i++){
                int dis = q.poll();
                if(dis == e) return level;
                for(int d=0; d < distances.length; d++){
                    int nextDis = dis + distances[d];
                    if(nextDis == e) return level+1;
                    if(nextDis >= 1 && nextDis <= 10000 && ch[nextDis] == 0){
                        ch[nextDis] = 1;
                        q.add(nextDis);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
