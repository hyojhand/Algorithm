package Study.Week20_24;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 1로 만들기2
public class Main12852 {
    static int N, min;
    static String result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bfs();
        System.out.println(min);
        System.out.println(result);
    }

    static void bfs() {
        Queue<Point> que = new LinkedList<>();
        boolean[] check = new boolean[N + 1];
        check[N] = true;
        que.offer(new Point(N + " ", N));

        int ans = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                String str = p.s;
                int num = p.num;

                if (num == 1) {
                    min = ans;
                    result = str;
                    return;
                }

                if (!check[num / 2] && num % 2 == 0) {
                    check[num / 2] = true;
                    que.offer(new Point(str + num / 2 + " ", num / 2));
                }
                if (!check[num / 3] && num % 3 == 0) {
                    check[num / 3] = true;
                    que.offer(new Point(str + num / 3 + " ", num / 3));
                }
                if(!check[num-1]) {
                    check[num - 1] = true;
                    que.offer(new Point(str + (num - 1) + " ", num - 1));
                }
            }
            ans++;
        }
    }

    static class Point {
        String s;
        int num;

        public Point(String s, int num) {
            this.s = s;
            this.num = num;
        }
    }
}