package online.strings;

import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(removeDuplicateAns(s));
    }

    static String removeDuplicate(String s){
        boolean [] boolArray = new boolean['z'-'a'+1];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!boolArray[c -'a']) {
                boolArray[c-'a'] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String removeDuplicateAns(String s){

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) == i){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


}
