package Study.Week9;

import java.io.*;
import java.util.*;
// 게리맨더링
public class Main17471 {
    static int N, people[], arr[][];
    static int min = Integer.MAX_VALUE;
    static boolean[] check;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        check = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            sum += people[i];
        }

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][num] = 1;
            }
        }

        dfs(0,0);

        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    public static void dfs(int a, int dept) {
        if (dept == N-1) return;
        if (min == 0) return;

        for (int i = a; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;

                int num = bfs(i);
                int num2 = 0;
                for (int j = 1; j <= N; j++) {
                    if (!check[j]) {
                        num2 = bfs2(j);
                        break;
                    }
                }

                if(sum == (num+num2)) {
                    min = Math.min(Math.abs(num-num2),min);
                }
                dfs(i,dept + 1);

                check[i] = false;
            }
        }
    }

    public static int bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        que.offer(x);
        count += people[x];
        boolean[] visit = new boolean[N + 1];
        visit[x] = true;

        while (!que.isEmpty()) {
            int q = que.poll();

            for (int i = 1; i <= N; i++) {
                if (check[i] && arr[q][i] == 1 && !visit[i]) {
                    que.offer(i);
                    visit[i] = true;
                    count += people[i];
                }
            }

        }
        return count;
    }

    public static int bfs2(int x) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        que.offer(x);
        count += people[x];
        boolean[] visit = new boolean[N + 1];
        visit[x] = true;

        while (!que.isEmpty()) {
            int q = que.poll();

            for (int i = 1; i <= N; i++) {
                if (!check[i] && arr[q][i] == 1 && !visit[i]) {
                    que.offer(i);
                    visit[i] = true;
                    count += people[i];
                }
            }
        }
        return count;
    }

}

