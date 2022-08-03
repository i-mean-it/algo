package online.hashmap_hashset;

import java.util.HashMap;
import java.util.Scanner;

public class SubsetAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String substring = sc.nextLine();
        System.out.println(findSubsetAnagramsCount(s, substring));
    }

    static int findSubsetAnagramsCount(String s, String substring){
        HashMap<Character, Integer> substringMap = new HashMap<>();
        HashMap<Character, Integer> stringMap = new HashMap<>();

        int removeP = 0;
        int count = 0;
        int addP = substring.length();

        for(int i = 0 ; i < substring.length(); i++){
            substringMap.put(substring.charAt(i), substringMap.getOrDefault(substring.charAt(i), 0) +1);
            stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) +1);
        }

        while(addP <= s.length()){
            if(substringMap.size() == stringMap.size() && substringMap.equals(stringMap)) count++;
            if(addP == s.length()) break;
            if(stringMap.get(s.charAt(removeP)) > 1)  stringMap.put(s.charAt(removeP), stringMap.get(s.charAt(removeP)) -1);
            else stringMap.remove(s.charAt(removeP));
            stringMap.put(s.charAt(addP), stringMap.getOrDefault(s.charAt(addP), 0) +1);
            removeP++;
            addP++;
        }
        return count;
    }
}
