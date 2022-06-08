package Study.Week13;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// DSLR
public class Main9019 {
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check = new boolean[10000];
            sb.append(bfs(a,b)).append('\n');
        }
        System.out.println(sb);
    }

    static String bfs(int start, int end) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start, ""));
        check[start] = true;

        while(!que.isEmpty()) {
            Point p = que.poll();
            int num = p.num;
            String str = p.str;

            if(num == end) return str;

            // D
            int temp = num*2;
            if(temp > 9999) temp%=10000;
            if(!check[temp]) {
                que.offer(new Point(temp, str + "D"));
                check[temp] = true;
            }

            // S
            temp = num-1;
            if(temp == -1) temp = 9999;
            if(!check[temp]) {
                que.offer(new Point(temp, str + "S"));
                check[temp] = true;
            }

            // L
            temp = (num%1000)*10 + num/1000;
            if(!check[temp]) {
                que.offer(new Point(temp, str + "L"));
                check[temp] = true;
            }

            // R
            temp = (num%10)*1000 + num/10;
            if(!check[temp]) {
                que.offer(new Point(temp, str + "R"));
                check[temp] = true;
            }

        }

        return "";
    }

    static class Point {
        int num;
        String str;
        public Point(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }

}
