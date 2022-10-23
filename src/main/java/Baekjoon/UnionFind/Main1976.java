package Baekjoon.UnionFind;

import java.io.*;
import java.util.StringTokenizer;
// 여행가자 G4
public class Main1976 {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        makeSet();
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) union(i,j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean travel = travel(st, M);
        if(travel) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void makeSet() {
        parents = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a,int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    static boolean travel(StringTokenizer st, int M) {
        int root = findSet(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++) {
            if(findSet(Integer.parseInt(st.nextToken())) != root) return false;
        }
        return true;
    }
}
