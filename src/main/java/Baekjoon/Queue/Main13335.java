package Baekjoon.Queue;

import java.io.*;
import java.util.*;
// S1 트럭 - 다리길이만큼 Queue에 넣어놓고, 하나씩 빼면서 다음 트럭이 다리에 올라갈 수 있다면 트럭을 넣고, 아니면 0을 넣어준다.
public class Main13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int sum = 0;
        int answer = 0;

        while(!truck.isEmpty()) {
            answer++;
            sum -= bridge.poll();

            if(sum + truck.peek() <= L) {
                sum += truck.peek();
                bridge.offer(truck.poll());
            } else {
                bridge.offer(0);
            }
        }

        answer += bridge.size();
        System.out.println(answer);
    }
}

