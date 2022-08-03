package codility.count_numbers;

public class FrogJump {
    public static void main(String[] args) {
        int [] leavesFallingSchedule = {1,3,1,4,2,3,5,4};
        int destination = 5;
        int ans = canFrogMakItToTheDest(destination , leavesFallingSchedule);
        System.out.println(ans);
    }

    static int canFrogMakItToTheDest(int X, int [] A){
        int destination = X+1;
        boolean [] hasLeaf = new boolean[X + 1];
        int count = 0;
        for(int i = 0 ; i < A.length; i++){
            if(!hasLeaf[A[i]]) {
                count++;
                hasLeaf[A[i]] = true;
                if(count == X) return i;
            }
        }
        return  -1;
    }
}
