package codility.stack_queues;

import java.util.Stack;

public class BuildStoneWall {
    public static void main(String[] args) {

    }

    static int findMinNumBricks(int[] H) {
        int minNumBricks = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < H.length; i++) {
            if (s.isEmpty() || s.peek() < H[i]) {
                s.push(H[i]);
                minNumBricks++;
            } else {
                while (!s.isEmpty() && s.peek() > H[i]) s.pop();
                if (s.isEmpty() || s.peek() < H[i]) {
                    s.push(H[i]);
                    minNumBricks++;
                }
                //if s.peek () == H[i] no additional block needed ... x extra job needed
            }
        }
        return minNumBricks;
    }

}

