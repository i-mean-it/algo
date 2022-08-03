package online.greedy;

import java.util.*;

class Lecture {
    int inDays;
    int pay;

    public Lecture(int inDays, int pay) {
        this.inDays = inDays;
        this.pay = pay;
    }

    public int getInDays() {
        return inDays;
    }

    public int getPay() {
        return pay;
    }
}

public class MostProfitSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Lecture> lectures = new ArrayList<>();

        int maxInDays = 0;
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int inDays = sc.nextInt();
            if (inDays > maxInDays) maxInDays = inDays;
            lectures.add(new Lecture(inDays, pay));
        }
        int ans = getMaxProfit(lectures, maxInDays);
        System.out.println(ans);
    }

    static int getMaxProfit(ArrayList<Lecture> lectures, int maxInDays) {
        int day = maxInDays;
        int i = 0;
        int sum = 0;
        Collections.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.getInDays() - o1.getInDays();
            }
        });

        PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.getPay() - o1.getPay();
            }
        });


        for (int d = day; d > 0; d--) {
            //같거나 크면 넣어야 되는게 더 맞을듯 ㅇㅇ  근데 일케 해도 크게 상관은 없음
            while (i < lectures.size() && lectures.get(i).getInDays() == d) {
                pq.add(lectures.get(i));
                i++;
            }
            if(!pq.isEmpty())  sum += pq.poll().getPay();
        }

        return sum;
    }
}
