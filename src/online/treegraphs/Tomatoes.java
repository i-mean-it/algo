package online.treegraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TomatoPosition{
    int row;
    int col;

    TomatoPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
public class Tomatoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int [][] storage = new int [row][col];
        for(int r = 0 ; r < row; r++){
            for(int c = 0 ; c < col; c++){
                storage[r][c] = sc.nextInt();
            }
        }
        int ans = getDaysForRipedTomatoes(storage, row, col);
        System.out.println(ans);

    }

    static int getDaysForRipedTomatoes(int [][] storage,int row, int col){
        Queue<TomatoPosition> q = new LinkedList<>();
        int tomatoCount = 0;
        int afterDays = 0;
        int riped = 0;
        int [] rowMoves = {0,0, 1, -1};
        int [] colMoves = {1, -1, 0,0};


        //익힌 토마토 찾기
        //총 토마토 개수 찾기
        for(int r=0; r < row; r++){
            for(int c=0; c < col; c++){
                if(storage[r][c] == 1 ) {
                    q.add(new TomatoPosition(r, c));
                    tomatoCount++;
                }else if(storage[r][c] == 0) tomatoCount++;
            }
        }
        if(tomatoCount == 0 || q.isEmpty()) return -1; //토마토가 아예 없거나 익은 토마토가 하나도 없는 경우
        else if (tomatoCount == q.size()) return 0; //들어있는 토마토가 이미 다 익은 거면

        riped += q.size();
        while(riped < tomatoCount && !q.isEmpty()){
            int currentQSize = q.size();
            for(int j = 0 ; j < currentQSize; j++){
                TomatoPosition currentPos = q.poll();
                int r  = currentPos.getRow();
                int c = currentPos.getCol();

                for(int i = 0 ; i < rowMoves.length; i++){
                    int nextRow = rowMoves[i] + r;
                    int nextCol = colMoves[i] + c;
                    if(nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col){
                        if(storage[nextRow][nextCol] == 0){
                            storage[nextRow][nextCol] = 1; //토마토 익히기
                            riped++;
                            q.add(new TomatoPosition(nextRow, nextCol));
                        }
                    }
                }
            }
            afterDays++;
        }


        if(riped < tomatoCount) return -1;
        return afterDays;
    }
}
