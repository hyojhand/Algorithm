package Baekjoon.Greedy;

import java.io.*;
import java.util.*;
// G5 강의실배정 - 가장 많이 강의를 들을 수 있는 강의장 수 -> Greedy + PQ
public class Main11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Point(start,end);
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].end);

        for(int i = 1; i < N; i++) {

            if(pq.peek() <= arr[i].start) pq.poll();

            pq.offer(arr[i].end);
        }

        System.out.println(pq.size());
    }

    static class Point {
        int start,end;
        public Point(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
}


