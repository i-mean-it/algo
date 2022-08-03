package online.treegraphs;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationWithRepitition{

    static int balls, howMany;
    public static void main(String[] args) {
        PermutationWithRepitition main = new PermutationWithRepitition();
        Scanner sc = new Scanner(System.in);
        balls = sc.nextInt();
        howMany = sc.nextInt();
        int [] a = new int[howMany];
        main.permute(0 , a);
    }

     void permute(int count, int [] a){
        if(count == howMany){
            //print
            Arrays.stream(a).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }else{
            for(int i=1 ; i <= balls; i++){
                a[count] = i;
                permute(count+1, a);
            }
        }
    }
}
