package online.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(checkIfProperBrackets(s));
    }

    private static String checkIfProperBrackets(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') st.add(c);
            else if(c == ')'){
                if(!st.isEmpty()) st.pop();
                else return "NO";
            }
        }
        if(st.isEmpty()) return "YES";
        return "NO";
    }
}
