package SWEA.Week4;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ChangYongVillage {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                parents[find(to)] = find(from);
            }

            for (int i = 1; i <= N; i++) {
                parents[i] = parents[find(i)];
            }

            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                hs.add(parents[i]);
            }

            int count = hs.size();

            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }

        System.out.println(sb);


    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);

    }
}
