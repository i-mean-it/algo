package online.arrays;

import java.util.Scanner;

public class PrimeNumsAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i = 0 ; i < n ; i++){
            array[i] = flipNums(sc.nextInt());
        }
        int [] sieve = completeSieve(new int[100001]);
        printPrimeNums(sieve, array);

    }

    static void printPrimeNums(int [] sieve, int [] array){
        for(int i = 0 ; i < array.length; i++){
            if(sieve[array[i]] == 0 ) System.out.print(array[i] + " ");
        }
    }

    static int flipNums(int n){
        String num = new StringBuilder(String.valueOf(n)).reverse().toString();

        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()){
            if(c >= '0' && c <= '9') sb.append(c);
        }

        return Integer.parseInt(sb.toString());
    }


    static int []  completeSieve(int [] sieve){
        sieve[0] = 1;
        sieve[1] = 1;
        for(int i = 2; i < sieve.length; i++) {
            if (sieve[i] == 0) {
                //isPrime
                for (int j = i + i; j <= 100000; j += i) {
                    sieve[j] = 1;
                }
            }
        }
        return sieve;
    }

}
