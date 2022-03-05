package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class HamiltonianCycle {
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(1, i, adjMatrix[0][i]);
            visited[i] = false;
        }

        System.out.println(min);

    }

    public static void dfs(int dept, int from, int sum) {
        if (sum > min) return;

        if (dept == N) {
            if(adjMatrix[from][0] == 0) return;
            sum += adjMatrix[from][0];
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i] && adjMatrix[from][i] != 0) {
                visited[i] = true;
                dfs(dept + 1, i, sum + adjMatrix[from][i]);
                visited[i] = false;
            }
        }


    }
}
