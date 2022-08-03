package online.arrays;
import java.util.*;
public class Rankings {


    /*
    30
65 54 81 56 54 70 61 87 99 58 78 99 99 70 96 60 77 84 67 86 84 98 63 96 83 54 52 86 78 69
     */
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Integer [] scores = new Integer[n];
        Integer [] ans = new Integer[n];
        for(int i = 0 ; i < n; i++) scores[i] = in.nextInt();
        for(int i = 0 ; i < n; i++) ans[i] = in.nextInt();

        printRankings(scores, ans);
        return ;
    }

    static void printRankings(Integer [] scores, Integer [] ans ){
        Integer [] copiedScores = Arrays.copyOf(scores, scores.length);
        int [] rankings = new int[101]; //100+1
        Arrays.sort(copiedScores, Comparator.reverseOrder());
        int ranking = 1;
        int sameRanking = 0;
        for(int i = 0; i < copiedScores.length; i++){
            if(rankings[copiedScores[i]] == 0){
                //updateRanking
                ranking += sameRanking;
                rankings[copiedScores[i]] =ranking;
                sameRanking = 0;
                ranking++;
            }else sameRanking++;
        }
        for(int i  = 0 ; i < scores.length; i++){
            System.out.println("score " + scores[i] + " rank: " + rankings[scores[i]] + "   ans: " + ans[i] );

        }
    }
}



