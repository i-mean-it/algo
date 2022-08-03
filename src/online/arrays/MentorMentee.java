package online.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MentorMentee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int exams = sc.nextInt();
        Integer [][] results = new Integer[exams][n];
        for(int r = 0 ; r < exams; r++){
            for(int c = 0 ; c < n; c++){
                results[r][c] = sc.nextInt();
            }
        }
        System.out.println(getMentorMenteePairNum(results, n , exams));
    }

    static int getMentorMenteePairNum(Integer [][] results, int n, int exams){
        int ans = 0 ;
        for(int i = 1; i <= n; i++){
            HashSet<Integer>  menteeCandidates = new HashSet<>(Arrays.asList(results[0]));
            menteeCandidates.remove(i);
            for(int r=0; r < exams; r++){
                for(int c=0; c < n; c++){
                    if(results[r][c] == i) break;
                    menteeCandidates.remove(results[r][c]);
                }
            }
            ans += menteeCandidates.size();
        }
        return ans;
    }
}


/*
20 2
        19 15 4 17 12 18 6 3 11 14 1 8 13 9 2 20 5 16 10 7
        5 20 18 17 14 11 19 3 10 16 6 8 13 9 2 12 4 7 1 15
        */
