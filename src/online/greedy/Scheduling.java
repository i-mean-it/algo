package online.greedy;

import java.util.Arrays;
import java.util.Scanner;

class Schedule implements Comparable<Schedule>{
    int start;
    int end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }


    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Schedule s2) {
        if(this.getEnd() == s2.getEnd()) return this.getStart() - s2.getStart();
        else return this.getEnd() - s2.getEnd();
    }
}
public class Scheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Schedule [] schedules = new Schedule[n];
        for(int i = 0; i < n; i++){
            schedules[i] = new Schedule(sc.nextInt(), sc.nextInt());
        }
        int ans = bestSchedule(schedules);
        System.out.println(ans);
        }

    private static int bestSchedule(Schedule[] schedules) {
        int count = 0;
        Arrays.sort(schedules);
        Schedule schedule = null;
        for(Schedule s: schedules) {
            if(schedule == null || schedule.getEnd() <= s.getStart() ){
                schedule = s;
                count++;
            }
        }
        return count;
    }

}
