package online.hashmap_hashset;

import java.util.Scanner;
import java.util.HashMap;

public class ElectionHashMap {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        getElectionResult(s);
        return ;
    }

    static void getElectionResult(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int highestVoteCount = 0;
        String winner = "";
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(Character c : map.keySet()){
            if(map.get(c) > highestVoteCount){
                highestVoteCount = map.get(c);
                winner = String.valueOf(c);
            }
        }

        System.out.println(winner);

    }
}

