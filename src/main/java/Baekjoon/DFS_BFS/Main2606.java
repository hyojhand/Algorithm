package Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2606 {
    static boolean[] visit;
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int testcase = Integer.parseInt(br.readLine());
        visit = new boolean[computer+1];
        arr = new int[computer+1][computer+1];

        StringTokenizer st;
        for(int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr[N][M] = 1;
            arr[M][N] = 1;
        }

        find(1,computer);

        System.out.println(count-1);

    }

    public static void find(int pre, int computer) {

        visit[pre] = true;
        count++;

        for(int i = 1; i <= computer; i++) {
            if(arr[pre][i] == 1 && !visit[i]) {
                find(i,computer);
            }
        }
    }
}
