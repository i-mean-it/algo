package online.arrays;

import java.util.Scanner;

public class PrimeNums {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int input1 = in.nextInt();
            //System.out.println(getPrimeNums(input1));
            System.out.println(sieveOfEratosthenes(input1));
            return ;
        }

        static int getPrimeNums(int n){
            int count = 0;
            for(int i = 2; i <= n; i++){
                if(isPrime(i)){
                    System.out.println(i);
                    count++;
                }
            }
            return count;
        }

        static boolean isPrime(int n){
            for(int i = 2; i <= Math.sqrt(n)  ; i++){
                if(n%i == 0) return false;
            }
            return true;
        }

    static int sieveOfEratosthenes(int n){
            int [] array = new int[n+1];
            int count = 0;

            for(int i = 2; i < n; i++){
                if(array[i] ==0){
                    System.out.println(i);
                    count++;
                    for(int j = i+1; j <= n; j++){
                        if(array[j] == 0 && j%i == 0) {
                            array[j] = 1;
                        }
                    }
                }
            }
            return count;
    }

}
