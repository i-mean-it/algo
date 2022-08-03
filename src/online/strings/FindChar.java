package online.strings;

import java.util.Scanner;

public class FindChar {
    public int solution(String str, char c){
        int answer = 0;

        c = Character.toUpperCase(c);
        str = str.toUpperCase();

        for(char x : str.toCharArray()){
            if(x == c) answer++;
        }
        /*for(int i = 0 ; i < str.length(); i ++){
            if(str.charAt(i) == c) answer++;
        }*/
        return answer;
    }

    public static void main(String[] args) {
        FindChar T = new FindChar();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
