package online.strings;

import java.util.Scanner;

public class Decryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(decrypt(s, n) );
    }

    static String decrypt(String s, int n ){
        System.out.println(s.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n*7 ; i+=7){
            String substring = s.substring(i,i+7);
            String binary = convertToBinary(substring);
            int  decimal = convertBinaryToDecimal(binary);
            char c = convertToAsciiChar(decimal);
            sb.append(c);
        }
        return sb.toString();
    }

    private static char convertToAsciiChar(int i) {
        return (char) i;
    }

    private static String convertToBinary(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '#') sb.append(1);
            else if(c == '*') sb.append(0);
        }
        return sb.toString();
    }

    private static int convertBinaryToDecimal(String s) {
        int power = 6;
        int sum = 0;
        for(char c : s.toCharArray()){
            if(c == '1') {
                sum +=  Math.pow(2, power);
               // sum += Math.pow(2,power);
            }
            power--;
        }
        return sum;
    }


}
