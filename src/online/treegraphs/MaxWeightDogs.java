package online.treegraphs;

import java.util.Scanner;

public class MaxWeightDogs {
    static int [] weights;
    static int numDogs;
    static int maxWeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxWeight = sc.nextInt();
        numDogs = sc.nextInt();
        weights = new int[numDogs];
        for(int i = 0 ; i < numDogs; i++){
            weights[i] = sc.nextInt();
        }
        System.out.println("answer is " + maxWeightDfs(0, 0));
    }

    static int maxWeightDfs(int totalWeight, int index){
        if(totalWeight > maxWeight) return -1; //this shouldn't work
        else if(index >= numDogs) return totalWeight; //this works \
        else{
            return Math.max(maxWeightDfs(totalWeight + weights[index] , index+1),
                    maxWeightDfs(totalWeight,index+1));
        }
    }
}
