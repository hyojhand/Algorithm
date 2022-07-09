package Study.Week20_24;

import java.io.*;
import java.util.StringTokenizer;
// 다각형의 면적
public class Main2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st. nextToken());
        double b = Integer.parseInt(st. nextToken());
        arr[0] = new Point(a,b);

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x,y);
        }
        arr[N] = new Point(a,b);

        double sum1 = 0;
        double sum2 = 0;
        for(int i = 0; i < N; i++) {
            sum1 += arr[i].x * arr[i+1].y;
            sum2 += arr[i].y * arr[i+1].x;
        }

        double result = Math.abs(sum1 - sum2)/2;
        System.out.println(String.format("%.1f", result));
    }

    static class Point {
        double x,y;
        public Point(double x,double y) {
            this.x = x;
            this.y = y;
        }
    }
}