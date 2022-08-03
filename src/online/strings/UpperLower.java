package online.strings;


import java.util.Scanner;

public class UpperLower {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        UpperLower u = new UpperLower();
        System.out.print(u.solution(s));
    }

    public String solution(String s){
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
