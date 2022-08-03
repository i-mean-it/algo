package online.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortingPractice {
    public static void main(String[] args) {
        //Array sort
        Brownie [] brownies = new Brownie[3];
        brownies[0] = new Brownie("Jjing");
        brownies[1] = new Brownie("Mint");
        brownies[2] = new Brownie("Cheese");
        Arrays.sort(brownies, new Comparator<Brownie>() {
            @Override
            public int compare(Brownie o1, Brownie o2) {
                return (o1.getName().compareTo(o2.getName()))*-1;
            }
        });
        System.out.println(Arrays.toString(brownies));
    }

    static class Brownie{
       String name;

       Brownie(String name){
           this.name = name;
       }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Brownie{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
