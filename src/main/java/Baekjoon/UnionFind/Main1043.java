package Baekjoon.UnionFind;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
// 거짓말 G4
public class Main1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] party = new HashSet[M+1];
        for (int i = 1; i <= M; i++) {
            party[i] = new HashSet<>();
        }

        st = new StringTokenizer(br.readLine());
        int know_num = Integer.parseInt(st.nextToken());
        boolean[] know = new boolean[N+1];
        for(int i = 0; i < know_num; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        makeSet();

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int party_num = Integer.parseInt(st.nextToken());

            if(party_num <= 1) {
                party[i].add(Integer.valueOf(st.nextToken()));
                continue;
            }

            int a = Integer.parseInt(st.nextToken());
            for(int j = 1; j < party_num; j++) {
                int b = Integer.parseInt(st.nextToken());
                if(findSet(a) != findSet(b)) union(a,b);

                party[i].add(a);
                party[i].add(b);

                a = b;
            }
        }

        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(know[i] && !visited[i]){
                int root = findSet(i);
                for (int j = 1; j <= N; j++){
                    if (findSet(j)==root) {
                        know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            boolean flag = false;
            for (int person : party[i]) {
                if(know[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);

    }

    static int N;
    static int[] parents;
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
}
