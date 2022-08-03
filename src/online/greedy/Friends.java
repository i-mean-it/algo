package online.greedy;

import java.util.Scanner;

/*
union find 문제
 */
/*
input :
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8
 */
public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        int numPairs = sc.nextInt();
        int [] groups = new int[numNodes+1];
        for(int i = 0 ; i < numNodes; i++) groups[i] = i;
        for(int i = 0 ; i < numPairs; i++){
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            union(f1, f2, groups);
        }
        int f1 = sc.nextInt();
        int f2 = sc.nextInt();
        int f1Group = find(f1, groups);
        int f2Group = find(f2, groups);
        if(f1Group == f2Group ) System.out.println("YES");
        else System.out.println("NO");
    }

    static int find(int f, int [] groups){
        if(f == groups[f]) return f;
        else return groups[f] = find(groups[f], groups);
    }

    static void union(int f1, int f2, int [] groups){
        int f1Group = find(f1, groups);
        int f2Group = find(f2, groups);
        if(f1Group != f2Group) groups[f1Group] = f2Group;
    }
}
