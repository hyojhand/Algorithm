package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;

// G1 도로 포장
// K개 이하의 도로를 통해서 이동했을 때 최소값이므로, 도로를 사용할 때의 값과 사용하지 않을 때의 값을 다익스트라로 계산해나간다.
// 이때 거리 배열은 distance[x][y] 로, x 지점까지 y번 도로를 건너올 때 비용을 의미한다.
// Node 객체에서 다음 이동지점까지 거리를 더해 도로를 지나지 않는 경우와
// 도로를 지날 수 있는 기회가 있으며 비용이 0이므로 최소값이 된다면 갱신해준다.
// 최종적으로 N 지점에 도착했을 때, K 이하의 거리 중 최소값을 구한다.
// 40%에서 시간초과가 발생했는데, 우선순위 큐에 담긴 노드의 현재까지 비용이 최소값이 될 수 없다면 continue 해주며 최소값을 만들지 못하는 경우는 바로 제외해준다.
public class Main1162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node>[] nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight, 0));
            nodes[to].add(new Node(from, weight, 0));
        }

        long[][] distance = dijkstra(N, K, nodes);

        long answer = Long.MAX_VALUE;
        for (long d : distance[N]) {
            answer = Math.min(answer, d);
        }

        System.out.println(answer);
    }

    static private long[][] dijkstra(int N, int K, List<Node>[] nodes) {
        long[][] distance = new long[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance[i], Long.MAX_VALUE);
        }

        // 현재 지점에서 0번 도로를 건너 출발한다.
        distance[1][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 우선순위 큐에 담긴 노드의 현재까지 비용이 최소값이 될 수 없다면 continue
            if (current.weight > distance[current.to][current.count]) {
                continue;
            }

            // 도로를 건너지 않는 경우 : 현재 값에 다리 비용을 더해 최소값을 만들 수 있다면 갱신
            for (Node node : nodes[current.to]) {
                if (distance[node.to][current.count] > distance[current.to][current.count] + node.weight) {
                    distance[node.to][current.count] = distance[current.to][current.count] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to][current.count], current.count));
                }

                // 도로를 건너는 경우 : K 보다 작아 도로를 건널 수 있고, 최소값을 만들 수 있다면 갱신
                if (current.count < K && distance[node.to][current.count + 1] > distance[current.to][current.count]) {
                    distance[node.to][current.count + 1] = distance[current.to][current.count];
                    pq.offer(new Node(node.to, distance[node.to][current.count + 1], current.count + 1));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int to, count;
        long weight;

        public Node(int to, long weight, int count) {
            this.to = to;
            this.weight = weight;
            this.count = count;
        }

        @Override
        public int compareTo(Node n) {
            return (int) (this.weight - n.weight);
        }
    }
}
