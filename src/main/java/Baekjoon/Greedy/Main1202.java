package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

// G2 보석 도둑
// 가방과 보석을 무게가 낮은 순서로 정렬
// 가장 낮은 무게의 가방에서 넣을 수 있는 만큼 우선순위 큐에 모두 넣고 가격이 높은 순서대로 하나씩 더해간다
public class Main1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 보석은 무게가 낮은 순서로 정렬
        PriorityQueue<Gem> gems = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            gems.offer(new Gem(weight, price));
        }

        // 가방 무게를 가지는 배열
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방은 무게 오름차순 정렬
        Arrays.sort(bags);

        // 결과값
        long answer = 0;

        // 담을 수 있는 가격을 저장하고 높은 순서로 정렬
        PriorityQueue<Integer> prices = new PriorityQueue<>(Comparator.reverseOrder());

        // 낮은 무게부터 담을 수 있는 보석을 모두 넣는다.
        for (int i = 0; i < K; i++) {

            // 보석이 남았다면 넣을 수 있는지 판단하고 넣는다.
            while (!gems.isEmpty()) {
                // 남은 보석은 가방의 무게보다 커서 넣을 수 없다면 break
                if (bags[i] < gems.peek().weight) {
                    break;
                }

                // 보석의 가격을 저장
                prices.offer(gems.poll().price);
            }

            // 가방 하나마다 가장 큰 값의 보석을 꺼낸다.
            if (!prices.isEmpty()) {
                answer += prices.poll();
            }
        }

        System.out.println(answer);
    }

    static class Gem implements Comparable<Gem> {
        int weight, price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            return this.weight - o.weight;
        }
    }
}
