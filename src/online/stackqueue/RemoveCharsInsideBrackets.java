package online.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveCharsInsideBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a = "apple";
        System.out.println(a.substring(5));
        removeCharsInBrackets( s);

    }

    static String removeCharsInBrackets2(String s){
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == '(') stack.push(index);
            else if(s.charAt(index) == ')'){
                int beginIndex = stack.pop();
                //i is the endIndex;
                s  = s.substring(0, beginIndex) + s.substring(index+1);
                index = beginIndex-1;
            }
            index++;
        }
        return s;
    }

    static void removeCharsInBrackets(String s){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for(char c : s.toCharArray()){
            if(c == ')') while(stack.pop()!= '(');
            else stack.push(c);
        }

        for(char c : stack){
            System.out.print(c);
        }

    }


}
