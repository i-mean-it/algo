package codility.stack_queues;

import java.util.Stack;

public class RIpFish {
    public static void main(String[] args) {
        int [] fishSizes = {4,3,2,1,5};
        int [] upOrDown = {0, 1, 0,0,0};

        int ans = numFishSurvivors(fishSizes, upOrDown);
        System.out.println(ans);
    }

    static int numFishSurvivors(int [] A, int [] B){
        //A = fish sizes , B = direction
        // 0 -> upstream
        // 1 = downstream
        Stack<Integer> downstreamFish = new Stack<>();
        int numSurvivors = 0;
        for(int i = 0; i < A.length; i++){
            if(B[i] == 1){ //downstream fish
                downstreamFish.push(A[i]);//size of the fish add it !
            }else { //downstream fish
                if(downstreamFish.isEmpty()) numSurvivors++;
                else{
                    boolean isUpstreamFishDead = false;
                    //the game begins between the two fish...
                    // //the upstream fish needs to keep fighting alone until downstream fish are all gone, if survives then becomes a survivor !
                    while(!downstreamFish.isEmpty() &&  !isUpstreamFishDead){
                        if(A[i] > downstreamFish.peek()) downstreamFish.pop();
                        else isUpstreamFishDead = true;
                    }
                    if(!isUpstreamFishDead) numSurvivors++;
                }
            }
        }
        return numSurvivors + downstreamFish.size();
    }
}
