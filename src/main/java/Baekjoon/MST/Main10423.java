package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G2 전기가 부족해
// 발전소와 연결된 케이블을 비용순으로 정렬하여 저장하는 우선순위 큐를 만든다.
// 연결이 가능한 케이블 순으로 연결하면서 해당 지점과 연결할 수 있는 케이블을 추가해나간다.
// 모두 연결되었는지 확인하고 최소비용을 반환한다.
public class Main10423 {
    static int N, M, K;
    static int[] parents;
    static List<Cable>[] cables;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        makeSet();

        st = new StringTokenizer(br.readLine());
        // 발전소 리스트
        List<Integer> powerCities = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int powerNumber = Integer.parseInt(st.nextToken());
            // 발전소는 -1로 초기화
            parents[powerNumber] = -1;
            powerCities.add(powerNumber);
        }

        cables = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            cables[i] = new ArrayList<>();
        }

        // 발전소와 연결된 케이블을 비용순으로 정렬하는 우선순위큐
        PriorityQueue<Cable> connections = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 각 지점에서 도착지점의 케이블 비용 저장
            cables[from].add(new Cable(from, to, weight));
            cables[to].add(new Cable(to, from, weight));

            // 발전소와 연결되었다면 연결할 케이블로 저장
            if (powerCities.contains(from)) {
                connections.offer(new Cable(from, to, weight));
            }

            if (powerCities.contains(to)) {
                connections.offer(new Cable(to, from, weight));
            }
        }

        int answer = 0;

        while (!connections.isEmpty()) {
            Cable cable = connections.poll();
            // 연결이 가능하면 연결하기
            if (union(cable.from, cable.to)) {
                answer += cable.weight;

                // 연결한 지점에서 가능한 케이블 추가
                for (Cable connectCable : cables[cable.to]) {
                    connections.offer(connectCable);
                }
            }

            // 모두 연결되었으면 break
            if (allConnect()) {
                break;
            }
        }

        System.out.println(answer);
    }

    // 모두 연결되었는지 확인
    private static boolean allConnect() {
        for (int i = 1; i < parents.length; i++) {
            // 하나라도 발전소와 연결되지 않았다면 false
            if (parents[i] != -1) {
                return false;
            }
        }
        return true;
    }

    // 단위집합 생성
    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    // 부모 노드 확인, -1(발전소)이면 -1 반환
    private static int findSet(int number) {
        if (number == -1) {
            return -1;
        }

        if (parents[number] == number) {
            return number;
        }

        return parents[number] = findSet(parents[number]);
    }

    // a,b 두 집합 합치기
    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }

        // 부모 노드가 -1(발전소)가 되도록
        if (bRoot == -1) {
            parents[aRoot] = bRoot;
        }

        parents[bRoot] = aRoot;
        return true;
    }

    static class Cable implements Comparable<Cable> {
        int from, to, weight;

        public Cable(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Cable c) {
            return this.weight - c.weight;
        }
    }
}
