package online.arrays;

import java.util.Scanner;

public class TemporaryBanjang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = sc.nextInt();
        int[][] matrix = new int[numStudents + 1][6];
        for (int r = 1; r <= numStudents; r++) {
            for (int y = 1; y <= 5; y++) {
                matrix[r][y] = sc.nextInt();
            }
        }
        int ans = getTemporaryBanjang(matrix);
        System.out.println(ans);
    }

    static int getTemporaryBanjang(int[][] matrix) {
        int[] numFriends = new int[matrix.length];
        int maxFriend = 0;
        int maxFriendStudent = -1;
        for (int s1 = 1; s1 < matrix.length; s1++) {
            for (int s2 = 1; s2 < matrix.length; s2++) {
                for (int year = 1; year <= 5; year++) {
                    if (matrix[s1][year] == matrix[s2][year]) {
                        numFriends[s1]++;
                        if(numFriends[s1] > maxFriend){
                            maxFriend = numFriends[s1];
                            maxFriendStudent = s1;
                        }
                        break;
                    }
                }
            }
        }
        return maxFriendStudent;
    }
}
