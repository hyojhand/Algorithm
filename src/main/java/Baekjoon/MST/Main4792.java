package Baekjoon.MST;

import java.io.*;
import java.util.*;

// P3 레드 블루 스패닝 트리
// "B"간선을 최소한 사용하는 개수와 최대한 사용하는 개수를 구한다.
// 무가중치 연결 그래프이지만, R,B 간선의 우선순위를 지정하기 위해 각각 가중치를 부여하는 간선 리스트를 생성한다.
// 1개의 간선 리스트에는 "B" 간선에 가중치를 부여하고, 다른 하나는 "R" 간선에 가중치를 부여해준다.
// 저장한 간선 리스트의 가중치를 기준으로 내림차순 정렬을 한다.
// 최소한의 "B" 간선 사용 개수를 얻기 위해 "R" 간선에 가중치가 부여된 배열을 사용해 최소 개수를 구한다.
// 반대로 최대한의 "B" 간선 사용 개수를 얻기 위해 "B" 간선에 가중치가 부여된 배열을 사용해 최대 개수를 구한다.
// 이때, 크루스칼 알고리즘을 사용하여 지점을 모두 연결하지 못하면 -1을 반환하고, 연결할 수 있다면 사용한 "B" 간선 개수를 반환한다.
// * 크루스칼 알고리즘의 union find 시에 path compression 으로 최적화 해준다.
// 최소,최대 둘 중 하나라도 모두 연결하지 못한 -1이 반환된다면 최종 결과로 0을 출력한다.
// 최소, 최대 개수의 범위안에 K가 들어있다면 최종 결과로 1을 출력한다.
public class Main4792 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 0, 0, 0 입력이 마지막 입력
            if (N == 0 && M == 0 && K == 0) {
                break;
            }

            // 간선의 색깔에 따라 가중치를 가지는 간선 리스트
            List<Node> blueNodes = new ArrayList<>();
            List<Node> redNodes = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String color = st.nextToken();
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                // 간선이 "B"라면, blueNodes에 가중치 1, redNodes에는 0으로 추가한다.
                // 반대로 간선이 "R"이라면, redNodes에서 가중치 1, blueNodes에서 가중치 0으로 추가한다.
                if (color.equals("B")) {
                    blueNodes.add(new Node(color, from, to, 1));
                    redNodes.add(new Node(color, from, to, 0));
                } else {
                    redNodes.add(new Node(color, from, to, 1));
                    blueNodes.add(new Node(color, from, to, 0));
                }
            }

            // 최대한 각 색깔의 간선만 사용하여 우선 연결을 위해 가중치순으로 정렬한다.
            Collections.sort(blueNodes);
            Collections.sort(redNodes);

            // "R"에 가중치가 부여된 redNodes로 크루스칼을 사용한 "B"간선의 최소 사용 개수
            int minBlueCount = kruskal(redNodes, N);
            // 반대로 "B"에 가중치가 부여된 blueNodes로 크루스칼을 사용한 "B" 간선의 최대 사용 개수
            int maxBlueCount = kruskal(blueNodes, N);

            // 모두 연결하지 못한 상황이 있다면 0 반환
            if (minBlueCount == -1 || maxBlueCount == -1) {
                result.append(0).append('\n');
            } else {
                // 최소,최대 범위 사이에 K가 존재하면 1 반환
                int answer = minBlueCount <= K && K <= maxBlueCount ? 1 : 0;
                result.append(answer).append('\n');
            }
        }

        System.out.println(result);
    }

    private static int kruskal(List<Node> nodes, int N) {
        // 정점의 루트 배열 초기화
        makeSet(N);

        int connectCount = 0; // 총 연결 개수
        int blueCount = 0; // B간선 개수

        for (Node node : nodes) {
            if (union(node.from, node.to)) {
                connectCount++;
                if (node.color.equals("B")) {
                    blueCount++;
                }
            }
        }

        // 모두 연결할 수 있다면 B간선 개수를 반환하고, 연결하지 못하면 -1 반환
        return connectCount == N - 1 ? blueCount : -1;
    }

    private static void makeSet(int N) {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int number) {
        if (parents[number] == number) {
            return number;
        }

        // path compression
        return parents[number] = findSet(parents[number]);
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
        String color;
        int from, to, weight;

        public Node(String color, int from, int to, int weight) {
            this.color = color;
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 높은 가중치순으로 내림차순 정렬
        @Override
        public int compareTo(Node n) {
            return n.weight - this.weight;
        }
    }
}

