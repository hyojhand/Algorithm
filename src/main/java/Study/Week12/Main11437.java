package Study.Week12;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// LCA
public class Main11437 {
    static int parents[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        find(1,1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] result = new boolean[N+1];

            result[a] = true;
            while (a != parents[a]) {
                result[parents[a]] = true;
                a = parents[a];
            }

            if(result[b]) sb.append(b).append('\n');
            else {
                while (b != parents[b]) {
                    if(result[parents[b]]) {
                        sb.append(parents[b]).append('\n');
                        break;
                    }
                    b = parents[b];
                }
            }
        }

        System.out.println(sb);
    }

    static void find(int num, int p) {
        parents[num] = p;
        for(int next : list[num]) {
            if(next != p) {
                find(next, num);
            }
        }
    }
}
