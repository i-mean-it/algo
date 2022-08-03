package online.greedy;


import java.util.Arrays;
import java.util.Scanner;

 class TimeStatus implements Comparable<TimeStatus>{
    int time;
    char state;

    public TimeStatus(int time, char state) {
        this.time = time;
        this.state = state;
    }

    public int getTime() {
        return time;
    }


    public char getState() {
        return state;
    }


     @Override
     public int compareTo(TimeStatus o) {
         if(this.getTime() == o.getTime()) return this.getState() - o.getState();
         return this.getTime() - o.getTime();
     }
 }
public class Marriage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TimeStatus [] arr = new TimeStatus[n*2];
        for(int i = 0 ; i < n*2 ; i+=2){
            arr[i] = new TimeStatus(sc.nextInt(), 's');
            arr[i+1] = new TimeStatus(sc.nextInt(), 'e');
        }
        int ans = getMaxPeoplePossible(arr);
        System.out.println(ans);
    }

    static int getMaxPeoplePossible(TimeStatus [] arr){
        Arrays.sort(arr);
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].getState() == 's'){
                count++;
                if(count > ans) ans = count;
            }else count--;
        }
        return ans;
    }
}
