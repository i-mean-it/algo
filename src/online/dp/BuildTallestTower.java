package online.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Brick{
    int area;
    int weight;
    int height;


    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    public int getArea() {
        return area;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}


/*

5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2


 */
public class BuildTallestTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> bricks = new ArrayList<>();
        for(int i = 0; i < n; i++){
            bricks.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int ans = getTallestTowerHeight(bricks);
        System.out.println(ans);
    }

    static int getTallestTowerHeight(ArrayList<Brick> bricks){
        Collections.sort(bricks, new Comparator<Brick>() {
            @Override
            public int compare(Brick o1, Brick o2) {
                return o1.getArea() - o2.getArea();
            }
        });
        int maxHeight = 0;
        int [] heights = new int[bricks.size()];

        for(int i = 0 ; i < bricks.size(); i++){
            int maxHeightSum = 0;
            for(int j = i; j >= 0; j--){
                if(bricks.get(i).getWeight() > bricks.get(j).getWeight()){
                    maxHeightSum = Math.max(maxHeightSum , heights[j]);
                }
            }
            heights[i] = bricks.get(i).getHeight() + maxHeightSum;
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        return maxHeight;
    }
}
