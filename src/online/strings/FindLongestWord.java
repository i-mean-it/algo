package online.strings;

import java.util.Scanner;

public class FindLongestWord {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String sentence = in.nextLine();
        String longestWord = getLongestWord(sentence);
        System.out.println(longestWord);
        return ;
    }

    public static String getLongestWord(String sentence){
        String longestWord = "";
        int index = 0;

        StringBuilder temp = new StringBuilder();
        while(index < sentence.length()){
            char c = sentence.charAt(index);
            if(c == ' '){
                if(temp.length() > longestWord.length()) longestWord = temp.toString();
                temp = new StringBuilder();
            }else if((c >= 'a'&& c <= 'z') || (c >= 'A' && c <= 'Z')){
                temp.append(c);
            }
            index++;
        }
        if(temp.length () > longestWord.length()) longestWord = temp.toString();
        return longestWord;
    }


}
