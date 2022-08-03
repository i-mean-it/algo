package online.hashmap_hashset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class KthBiggestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(getKthBiggestSum(n, k , a));
    }

    private static int getKthBiggestSum(int n, int k, int[] a) {
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int f = 0 ; f < a.length; f++){
            for(int s = 0; s < a.length; s++){
                if(s == f) continue;
                for(int t = 0; t < a.length; t++){
                    if(t == f || t == s) continue;
                    treeSet.add(a[f] + a[s] + a[t]);
                }
            }
        }
        Iterator<Integer> it = treeSet.iterator();
        int count = 1;
        while(count < k){
            it.next();
            count++;
        }
        return it.next();
    }
}
