package Study.Week6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9205 {
    static boolean[] visit;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int N = Integer.parseInt(br.readLine()) + 2;

            int[][] arr = new int[N][2];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    int move_x = Math.abs(arr[i][0] - arr[j][0]);
                    int move_y = Math.abs(arr[i][1] - arr[j][1]);
                    if (move_x + move_y <= 1000) {
                        map[i][j] = 1;
                        map[j][i] = 1;
                    }
                }
            }

            visit[0] = true;
            bfs(0, N);

            T--;
        }
        System.out.println(sb);
    }

    public static void bfs(int start, int N) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        boolean flag = false;

        while (!que.isEmpty()) {
            int num = que.poll();

            for (int i = 0; i < N; i++) {
                if (!visit[i] && map[num][i] == 1) {
                    que.offer(i);
                    visit[i] = true;
                }
            }

            if (map[num][N-1] == 1) {
                flag = true;
                break;
            }
        }

        if (flag) sb.append("happy").append('\n');
        else sb.append("sad").append('\n');
    }
}
