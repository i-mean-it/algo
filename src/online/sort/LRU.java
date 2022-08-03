package online.sort;

import java.util.Arrays;
import java.util.Scanner;

public class LRU {
    /*
    input
    5 9
    1 2 3 2 6 2 3 5 7

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int jobSize = sc.nextInt();
        int [] jobs = new int [jobSize];
        for(int i = 0 ; i < jobSize; i++) jobs[i] = sc.nextInt();
        int [] cache = lruCache(jobs, cacheSize);
        System.out.println();
        Arrays.stream(cache).forEach(c -> System.out.print(c + " "));
    }

    static int [] lruCache(int [] jobs, int cacheSize){
        int jobsInCache = 0;
        int [] cache = new int[cacheSize];

        for(int i = 0 ; i < jobs.length; i++){
            int inCache = isInCache(cache, jobs[i]);
            if(inCache > 0){
                shift(inCache,  cache);
            }else{
                if(jobsInCache != 0)  shift(jobsInCache, cache);
                if(jobsInCache < cacheSize) jobsInCache++;
            }
            cache[0] = jobs[i];
        }
        return cache;
    }

    static void shift(int start, int [] cache){
        for(int i = start-1; i >= 0; i--){
            if(i+1 < cache.length){
                cache[i+1] = cache[i];
            }
        }
    }

    static int isInCache(int [] cache, int j){
        for(int i = 0 ; i < cache.length; i++){
            if(j == cache[i]) return i;
        }
        return -1;
    }

}
