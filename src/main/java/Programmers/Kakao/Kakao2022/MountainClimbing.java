package Programmers.Kakao.Kakao2022;

import java.util.*;
import java.util.stream.Collectors;

// 2022 KAKAO TECH INTERNSHIP - 등산코스 정하기
// contains로 출입구, 산봉우리를 찾기위해 리스트로 저장한다.
// 출입구라면 다른 곳으로 가는, 산봉우리면 다른곳에서 들어오는 단방향으로만 추가하고, 나머지 지점은 양방향으로 저장해준다.
// 각 출입구를 시작으로 다익스트라를 수행한다. distance 배열은 해당 지점까지 이어온 최대값을 저장한다.
// 다익스트라로 지금까지의 최대값과 다음 연결할 지점의 최대값보다 작은 경로가 있다면 최소값으로 갱신하며, 최소값의 경로 중 최대값을 저장해나간다.
// 최종적으로 정렬된 산봉우리까지의 최대값 중 최소값을 구한다.
public class MountainClimbing {
    int number = Integer.MAX_VALUE;
    int intensity = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] nodes = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        List<Integer> gateList = Arrays.stream(gates).boxed().collect(Collectors.toList());
        List<Integer> summitList = Arrays.stream(summits).boxed().collect(Collectors.toList());

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            // 출입구라면 다른 곳으로 가는, 산봉우리면 다른곳에서 들어오는 단방향으로만 추가
            if (gateList.contains(from) || summitList.contains(to)) {
                nodes[from].add(new Node(to, weight));
            } else if (gateList.contains(to) || summitList.contains(from)) {
                nodes[to].add(new Node(from, weight));
            } else {
                nodes[from].add(new Node(to, weight));
                nodes[to].add(new Node(from, weight));
            }
        }

        dijkstra(gates, summits, nodes);

        return new int[]{number, intensity};
    }

    private void dijkstra(int[] gates, int[] summits, List<Node>[] nodes) {
        int[] distance = new int[nodes.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Node> que = new LinkedList<>();
        for (int gate : gates) {
            distance[gate] = 0;
            que.offer(new Node(gate, 0));
        }

        while (!que.isEmpty()) {
            Node current = que.poll();

            for (Node node : nodes[current.to]) {
                int dis = Math.max(distance[current.to], node.weight);

                if (distance[node.to] > dis) {
                    distance[node.to] = dis;
                    que.offer(new Node(node.to, dis));
                }
            }
        }

        Arrays.sort(summits);
        for (int summit : summits) {
            if (intensity > distance[summit]) {
                intensity = distance[summit];
                number = summit;
            }
        }
    }

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
