package online.hashmap_hashset;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(isAnagram(s1,s2)) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean isAnagram(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();

        //complete map
        for(char c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c, 0) +1);
        }

        for(char c : s2.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            if(map.get(c) > 0) map.replace(c , map.get(c)-1);
        }
        return true;
    }
}
