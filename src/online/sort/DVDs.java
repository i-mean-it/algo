package online.sort;

import java.util.Scanner;

public class DVDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSongs = sc.nextInt();
        int numCds = sc.nextInt();
        int [] songs = new int[numSongs];
        int longestSongLength = -1;
        int sum = 0;
        for(int i = 0 ; i < numSongs; i++) {
            songs[i] = sc.nextInt();
            sum += songs[i];
            if(songs[i] > longestSongLength) longestSongLength = songs[i];
        }
        System.out.println(getBestCdSize(numSongs, numCds, songs, longestSongLength, sum));
    }

    private static int getBestCdSize(int numSongs, int numCds, int[] songs, int longestSongLength, int sum) {
        int lt = longestSongLength;
        int rt = sum;
        int ans = sum;
        while(lt <= rt){
            int mid = (lt + rt)/2 ;
            if(cdSizeWorks(songs , mid, numCds)){
                ans = mid;
                rt = mid-1;
            }else{
              lt = mid+1;
            }
        }
        return ans;
    }

    private static boolean cdSizeWorks(int [] songs, int cdSize, int numCds){
        int count = 0;
        int size = 0;
        int index = 0;
        while(count <= numCds && index < songs.length){
            if(songs[index]+ size < cdSize){
                size += songs[index];
            }else if(songs[index] + size == cdSize) {
                size = 0;
                count++;
            }else{
                size = songs[index];
                count++;
            }
            index++;
        }
        if(size > 0) count++;
        if(count <= numCds) return true;
        else return false;
    }

}

