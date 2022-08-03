package online.treegraphs;

import java.util.Scanner;

public class MaxPossibleScore {
    static int numProblems;
    static int maxScore;
    static int maxMin;
    static int [] mins;
    static int [] points;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numProblems = sc.nextInt();
        maxMin = sc.nextInt();
        mins = new int[numProblems];
        points = new int[numProblems];
        for(int i = 0; i < numProblems; i++){
            points[i] = sc.nextInt();
            mins[i] = sc.nextInt();
        }
        int ans = maxScoreDfs(0,0,0);
        System.out.println("ans = " + ans);
    }

    static int maxScoreDfs(int totalMin, int totalScore, int index){
        if(totalMin > maxMin) return -1;
        else if(totalMin == maxMin || index >= numProblems) return totalScore;
        else{
            return Math.max(maxScoreDfs(totalMin + mins[index], totalScore + points[index],  index+1),
                    maxScoreDfs(totalMin, totalScore,index+1));
        }
    }
}
