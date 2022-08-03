package online.treegraphs;

import java.util.ArrayList;
import java.util.Scanner;
class Loc{
    int row;
    int col;

    public Loc(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString(){
        return "("+ this.getRow() + ", " + this.getCol() + ")" ;
    }
}

//get combination
        /*combinations = factorial(numShops)
                /(factorial(numShops-numShopsToChoose) * factorial(numShopsToChoose)) ;*/
public class MinDistancePizzaShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mapSize = sc.nextInt();
        int numShops = sc.nextInt();
        ArrayList<Loc> shops = new ArrayList<>();
        ArrayList<Loc> houses = new ArrayList<>();
        int [][] map = new int[mapSize][mapSize];
        for(int r=0; r < map.length; r++){
            for(int c=0; c< map.length; c++){
                map[r][c] = sc.nextInt();
                if(map[r][c] == 2) shops.add(new Loc(r, c));
                else if(map[r][c] == 1) houses.add(new Loc(r,c));
            }
        }
        int ans = getCityMinDeliveryDistance(map, numShops, houses, shops);
        System.out.println(ans);


    }

    static int getCityMinDeliveryDistance(int [][] map, int numShopsToChoose, ArrayList<Loc>houses, ArrayList<Loc> shops){
        //dfs로 combination 구하기
        int minDistance = 0;
        ArrayList<ArrayList<Loc>> combinations = new ArrayList<>();
        int minDis = choosePizzaShopsWithMinDistance(new ArrayList<>(), shops, houses,0, numShopsToChoose);
        return minDis;
    }

    static int choosePizzaShopsWithMinDistance(ArrayList<Loc> chosenPizzaShops, ArrayList<Loc> shops, ArrayList<Loc> houses,
                                 int index,  int numShopsToChoose){
        if(chosenPizzaShops.size() == numShopsToChoose){
//            chosenPizzaShops.stream().forEach(System.out::println);
//            combinations.add(new ArrayList<>(chosenPizzaShops));
            //계산 시작
            int sum = 0;

            for(int j = 0 ; j < houses.size(); j++){
                int minDis = Integer.MAX_VALUE;
                for(int i = 0 ; i < numShopsToChoose; i++){
                    int dis = getDistanceBetween(houses.get(j), chosenPizzaShops.get(i));
                    minDis = Math.min(dis , minDis);
                }
                sum += minDis;
            }
            return sum;
        }
        int minDis = Integer.MAX_VALUE;
        for(int i = index; i < shops.size() ; i++){
            chosenPizzaShops.add(shops.get(i));
            minDis = Math.min(choosePizzaShopsWithMinDistance(chosenPizzaShops, shops, houses, i+1, numShopsToChoose), minDis);
            chosenPizzaShops.remove(shops.get(i));
        }
        return minDis;
    }

    static int getDistanceBetween(Loc a, Loc b){
        return Math.abs(a.getCol()-b.getCol()) + Math.abs(a.getRow() - b.getRow());
    }

    static int factorial(int n){
        int ans = 1;
        for(int i = 2; i <=n; i++){
            ans *= n;
        }
        return ans;
    }
}
