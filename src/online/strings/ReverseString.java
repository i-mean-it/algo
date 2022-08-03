package online.strings;

public class ReverseString {
        public static void main(String[] args){
            String [] array = {"good", "Time", "Big"};
            reverseWords(array);
            Math.sqrt(5);
            return ;
        }

        static void reverseWords(String [] array){
            for(String s: array) System.out.println(new StringBuilder(s).reverse().toString());
        }

}
