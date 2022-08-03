package online.strings;

import java.util.Scanner;

public class ZipStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = zipString(s);
        System.out.println("ans = " + ans);
    }

    static String zipString(String s){
        char prevChar = ' ';
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(prevChar != c){
                if(count > 0){
                    sb.append(prevChar);
                    if(count > 1) sb.append(count);
                }
                count = 0;
            }
            prevChar = c;
            count++;
        }

        if(count > 0){
            sb.append(prevChar);
            if(count > 1) sb.append(count);
        }
        return sb.toString();
    }


}
