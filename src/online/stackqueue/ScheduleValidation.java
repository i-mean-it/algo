package online.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class ScheduleValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prerequisites = sc.nextLine();
        String schedule = sc.nextLine();
        System.out.println(validateSchedule(prerequisites, schedule));
    }

    private static String validateSchedule(String prerequisites, String schedule) {
        Stack<Character> preReqSt = new Stack<>();
        Stack<Character> scheduleSt = new Stack<Character>();
        for(char c : prerequisites.toCharArray()) preReqSt.add(c);
        for(char c: schedule.toCharArray()) scheduleSt.add(c);
        while(!scheduleSt.isEmpty()){
            if(scheduleSt.peek() == preReqSt.peek()) preReqSt.pop();
            scheduleSt.pop();
        }
        if(preReqSt.isEmpty()) return "YES";
        else return "NO";

    }
}
