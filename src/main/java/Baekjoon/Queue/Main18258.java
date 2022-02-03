package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> que = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            switch (func) {
                case "push":
                    que.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer num = que.poll();
                    if(num == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(num).append('\n');
                    }
                    break;
                case "size":
                    sb.append(que.size()).append('\n');
                    break;
                case "empty":
                    if(que.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    Integer first = que.peek();
                    if(first == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(first).append('\n');
                    }
                    break;
                case "back":
                    Integer end = que.peekLast();
                    if(end == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(end).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);

    }
}
