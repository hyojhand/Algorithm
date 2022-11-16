package Baekjoon.UnionFind;

import java.io.*;
import java.util.*;
// G5 여러분의 다리가 되어 드리겠습니다
public class Main17352 {
    static int N;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        makeSet();

        for(int i = 0; i < N-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        int num = findSet(1);
        for(int i = 2; i <= N; i++) {
            if(findSet(i) != num) {
                System.out.println(findSet(i) + " " + num);
                break;
            }
        }
    }


    static void makeSet() {
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return findSet(parents[a]);
    }

    static void union(int a,int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot != bRoot) {
            if(aRoot < bRoot) parents[bRoot] = aRoot;
            else parents[aRoot] = bRoot;
        }
    }
}
