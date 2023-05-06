package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G4 도시 건설 - MST
// 먼저, 각 시작점과 연결된 경로를 저장할 리스트 배열을 초기화한다.
// 시작,끝 점을 양방향으로 리스트 배열에 추가한다. 이때, 총 비용을 저장해나간다. (자료형은 long 주의)
// 각 점에서 부모 배열을 자기 자신으로 초기화해준다.
// 출발,도착,비용으로 구성된 Node 객체를 최소비용순으로 정렬하는 우선순위 큐를 생성하고, 하나의 시작점부터 큐에 넣고 시작한다.
// 큐가 빌 때까지 반복하며, 최소비용으로 꺼낸 시작점과 도착점의 루트가 같다면 연결된 경로이므로 넘어간다.
// 연결되지 않았다면 union하여 연결하고, 사용한 비용에 더해준다.
// 최근에 연결한 도착점을 시작으로하는 모든 경로를 탐색하여 최근 연결한 점과 연결되지 않은 모든 경로를 큐에 넣는다.
// 최소비용으로 우선순위 큐에 의해 정렬되므로 다시 반복해준다.
// 최종적으로 연결한 개수가 모든 정점의 개수와 같다면 모두 연결된 것이므로 결과를 반환하고, 그렇지 않으면 -1을 반환해준다.
public class Main21924 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 총 비용
        long sum = 0;

        // 경로를 저장할 리스트 초기화
        List<Node>[] routes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            routes[i] = new ArrayList<>();
        }

        // 경로 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            routes[from].add(new Node(from, to, weight));
            routes[to].add(new Node(to, from, weight));

            // 총 비용 저장
            sum += weight;
        }

        // 최소비용순으로 정렬된 Node 객체 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 부모배열 초기화
        parents = new int[N + 1];
        makeSet(N);

        // 합친 개수
        int count = 0;
        long answer = 0;

        pq.offer(new Node(0, 1, 0)); // 1부터 시작

        // 사이클이 존재하는지 확인하면서 최소비용으로 연결
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 루트가 같아, 이미 연결된 경로라면 continue
            if (findSet(node.from) == findSet(node.to)) {
                continue;
            }

            // 두 경로를 연결하고, 결과 & 연결 개수 추가
            union(node.from, node.to);
            answer += node.weight;
            count++;

            // 현재 노드에서 연결된 경로 탐색
            for (Node nextNode : routes[node.to]) {
                // 연결되지 않은 경로 모두 담기
                if (findSet(node.to) != findSet(nextNode.to)) {
                    pq.offer(nextNode);
                }
            }
        }

        // 모두 연결하지 못하면 -1
        answer = count == N ? sum - answer : -1;
        System.out.println(answer);
    }

    private static void makeSet(int N) {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int number) {
        if (parents[number] == number) {
            return number;
        }

        return findSet(parents[number]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }

    static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
}

