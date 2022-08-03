package codility.time_complexity;

public class MinFrogJumps {
    public static void main(String[] args) {
        int start = 10;
        int dest = 85;
        int frogJumpDistance = 30;
        System.out.println(getMinFrogJumps(start, dest, frogJumpDistance));
    }

    static int getMinFrogJumps(int start, int dest, int frogJumpDistance){
        int distance = dest - start;
        double remainder  = distance % frogJumpDistance;
        int quotient = distance / frogJumpDistance;
        return quotient + (remainder == 0 ? 0 : 1);
    }
}
