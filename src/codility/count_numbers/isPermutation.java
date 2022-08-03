package codility.count_numbers;

public class isPermutation {
    public static void main(String[] args) {
        int [] A = {4, 1, 3, 2};
        int [] A1 = {4,1,3};
        checkIfPermutation(A);
        checkIfPermutation(A1);
    }
    public static int  checkIfPermutation(int [] A){
        //given array A with length N ... is permutation if 1... N without missing any of the numbers , need only 1 of each elements
        int ans = 1;
        int [] counts = new int[A.length+1];
        for(Integer n : A){
            if(n > A.length) return 0; //if(A.length == 3 ... and one of the number is 4 ... then 1...3 4 doesn't belong in the permutation
            else counts[n]++;
        }
        for(int i = 1; i < counts.length; i++){
            if(counts[i] == 0|| counts[i] > 1) return 0; // more than 1 occurences or not in the array at all !
        }
        return ans;
    }
}
