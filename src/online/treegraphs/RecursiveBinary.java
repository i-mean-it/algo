package online.treegraphs;

public class RecursiveBinary {
    public static void main(String[] args) {

        String ans = getBinaryRecursively(11,"");
        System.out.println(ans);

    }

    static String getBinaryRecursively(int n, String s){
        //binary 구하는 방법
        if(n == 0) return s;
        else{
            int remainder = n%2;
            String string = getBinaryRecursively(n/2, s);
            string += remainder;
            System.out.println("remainder  = " + remainder + " String = " + string + " n =" + n);
            return string;
        }
    }
}
