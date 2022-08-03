package online.arrays;

import java.util.HashMap;

public class RockScissorsPaper {

    public static void main(String[] args) {
        int [] aGame = {2,3,3,1,3};
        int [] bGame = {1,1,2,2,3};
        printWinners(5, aGame, bGame);

    }

    static void printWinners(int n, int [] aGame, int [] bGame){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "scissors");
        map.put(2, "rock");
        map.put(3, "paper");

        for(int i=0; i < n; i++) {
            String a = map.get(aGame[i]);
            String b = map.get(bGame[i]);

            if (a.equals(b)) System.out.println("D");
            else {
                if (a.equals("scissors") && b.equals("paper")) System.out.println("A");
                else if (a.equals("rock") && b.equals("scissors")) System.out.println("A");
                else if (a.equals("paper") && b.equals("rock")) System.out.println("A");
                else System.out.println("B");
            }
        }
    }

}
