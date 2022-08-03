package online.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class PostFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        doPostFix(s);
    }

    private static void doPostFix(String s) {
        Stack<String> stack = new Stack<>();
        Integer first = null;
        Integer second = null;
        for(Character c: s.toCharArray()){
            if(Character.isDigit(c)) stack.push(String.valueOf(c));
            else{
                second = Integer.parseInt(stack.pop());
                first = Integer.parseInt(stack.pop());
                int ans = doOperation(first, second, c);
                stack.push(String.valueOf(ans));
            }
        }

        System.out.println(stack.pop());

    }

    static Integer doOperation(int f, int s, Character op){
        if(op == '+') return f+s;
        else if(op == '-') return f-s;
        else if(op == '*') return f*s;
        else if(op == '/') return f/s;
        return null;
    }
}
