package Baekjoon.UnionFind;

import java.io.*;
import java.util.StringTokenizer;
// G4 은하철도
public class Main17250 {
    static int N,M;
    static int[] planet,parents;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        planet = new int[N+1];
        check = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            planet[i] = Integer.parseInt(br.readLine());
        }

        makeSet();

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(union(a,b)).append('\n');
        }

        System.out.println(sb);
    }

    static void makeSet() {
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return findSet(parents[a]);
    }

    static int union(int a,int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return planet[aRoot];

        if(aRoot < bRoot) {
            parents[bRoot] = aRoot;
            planet[aRoot] += planet[bRoot];
            return planet[aRoot];
        }
        else {
            parents[aRoot] = bRoot;
            planet[bRoot] += planet[aRoot];
            return planet[bRoot];
        }
    }
}
