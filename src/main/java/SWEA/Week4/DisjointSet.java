package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class DisjointSet {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            tc++;
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parents = new int[N + 1];

            // makeSet
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int func = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (func == 0) {
                    union(a, b);
                } else {
                    if (find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        parents[bRoot] = aRoot;
    }

    public static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

}
