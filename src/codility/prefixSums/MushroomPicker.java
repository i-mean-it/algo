package codility.prefixSums;

public class MushroomPicker {
    public static void main(String[] args) {
        int [] a = {2,3,7,5,1,3,9};
        System.out.println(maxMushrooms(a, 4, 6));


    }

    // Time: O(M + N)
    // Space: O(N)
    static int maxMushrooms(int [] a, int k , int m){
        int n = a.length;
        int result = 0;
        int [] pref = prefixSums(a);
        //to left
        for(int i = 0; i < Math.min(m, k); i++){
            int left = k-i;
            int right = Math.min(n-1, Math.max(k, k + m - 2 * i));
            result = Math.max(result, pref[right] - pref[left-1]);
        }

        //to right
        for(int i = 0 ; i < Math.min(m + 1 , n - k); i++){
            int right = k + i;
            int left = Math.max(1, Math.min(k, k - (m - 2 * i)));
            result = Math.max(result, pref[right] - pref[left-1]);
            //만약 index 3-6 구하는거면
            //index = 3 앞에 0 , 1, 2 합 빼면 됌 ,,, pref[2]
            //pref[6]-pref[2];
        }
        return result;
    }

    static int [] prefixSums(int [] a){
        int [] prefixSum =  new int[a.length+1];
        prefixSum[0] = a[0];
        for(int i = 1; i < a.length; i++){
            prefixSum[i] = prefixSum[i-1] + a[i];
        }
        return prefixSum;
    }


}

