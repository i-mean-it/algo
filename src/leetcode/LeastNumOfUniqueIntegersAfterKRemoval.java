package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeastNumOfUniqueIntegersAfterKRemoval {
    public static void main(String[] args) {
        System.out.println(getLeastNumOfUniqueIntegersAfterKRemoval(4, new int [] {1,2,2,2,2}));
    }

    static int getLeastNumOfUniqueIntegersAfterKRemoval(int k, int [] arr){
        int ans = 0;
        int uniqueElementsCount = 0;
        HashMap<Integer, Integer>  map = new HashMap<>();
        for(Integer i : arr)
            map.put(i, map.getOrDefault(i, 0)+1);
        uniqueElementsCount = map.keySet().size();

        if(k == 0) return uniqueElementsCount;

        List<Integer> sortedByCountList = map.entrySet().stream()
                .sorted((o1, o2) -> {return o1.getValue() - o2.getValue();})
                .map(e -> e.getKey()).collect(Collectors.toList());
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a,b) -> map.get(a) - map.get(b));
        Collections.sort(keys, Comparator.comparingInt(map::get));
        for(Integer i : sortedByCountList){
            if(k <= 0) break;
            int intCount = map.get(i);
            if(intCount <= k ){ //remove that num from map
                map.remove(i);
                k -= intCount;
            }else{
                map.put(i, map.get(i) -k );
            }
        }
        return map.keySet().size();
    }
}
