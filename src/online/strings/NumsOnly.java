package online.strings;

import java.util.Scanner;

public class NumsOnly {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        getNumsOnly(s);
        return ;
    }

    static void getNumsOnly(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
