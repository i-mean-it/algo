package online.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
input
5
2 7
1 3
1 2
2 5
3 6

 */

public class SortCoordinates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordinate [] arr  = new Coordinate[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Coordinate(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.getX() == o2.getX()) return o1.getY() - o2.getY();
                else return o1.getX()-o2.getX();
            }
        });

        Arrays.stream(arr).forEach(c -> System.out.println(c));
    }


    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(){

        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
