package online.sort;

import java.util.Arrays;
import java.util.Scanner;

public class HorseStable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stables = sc.nextInt();
        int numHorses = sc.nextInt();
        int [] locations = new int[stables];
        for(int i = 0 ; i <stables; i++) locations[i] = sc.nextInt();
        Arrays.sort(locations);
        System.out.println(getMaxDistanceBetweenClosestHorses(locations, numHorses, stables));

    }

    static int getMaxDistanceBetweenClosestHorses(int [] locations, int numHorses, int stables){
        int lt = 1;
        int rt = locations[stables-1];
        int ans = 0;
        while(lt <= rt){
            int mid = (lt + rt) /2;
            int lastPos = 0;
            int horsesPlaced = 1;
            for(int i = 0 ; i < stables; i++){
                if(locations[i] - locations[lastPos] >= mid) {
                    lastPos = i;
                    horsesPlaced++;
                }
            }
            if(horsesPlaced >= numHorses){
                lt = mid+1;
                ans = mid;
            }else{
                rt = mid-1;
            }
        }
        return ans;
    }
}
