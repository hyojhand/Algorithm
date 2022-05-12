package Study.Week12;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 배달
public class Main8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Point[] arr = new Point[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            arr[i] = new Point(from,to,box);
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.to == o2.to) return o1.from - o2.from;
                return o1.to - o2.to;
            }
        });

        int result = 0;
        int[] weight = new int[N+1];
        for(int i = 0; i < M; i++) {
            int start = arr[i].from;
            int end = arr[i].to;
            int box = arr[i].box;

            int idx = start;

            int max = 0;
            for(int k = start; k < end; k++) {
                max = Math.max(max,weight[k]);
            }

            if(C-max < box) box = C-max;

            boolean flag = true;

            while(idx < end) {
                if(C-weight[idx] < box) {
                    flag =false;
                    break;
                }
                idx++;
            }

            if(flag) {
                for(int k = start; k < end; k++) {
                    weight[k] += box;
                }
                result += box;
            }
        }
        System.out.println(result);
    }

    static class Point {
        int from,to,box;
        public Point(int from,int to,int box) {
            this.from = from;
            this.to = to;
            this.box = box;
        }
    }
}

