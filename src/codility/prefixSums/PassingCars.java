package codility.prefixSums;

public class PassingCars {
    public static void main(String[] args) {
        int [] cars = {0, 1, 0, 1, 1};
        System.out.println(numPairsPassingCars(cars));
    }

    static int numPairsPassingCars(int [] A) {
        int zeroCount = 0;
        long numPairs = 0;
        for (Integer n : A) {
            if (n == 0) zeroCount++;
            else {
                numPairs += zeroCount;
            }
        }
        if (numPairs > 1000000000) return -1;
        return (int) numPairs;
    }
}
