package Baekjoon.LCA;

import java.io.*;
import java.util.*;

// G3 LCA
// 먼저, 입력으로 들어오는 각 정점에서 연결된 간선 리스트를 저장한다.
// 루트를 1로 가지는 트리에서 공통 조상을 찾기 위해 모든 정점의 깊이와 부모 정점의 값을 구해준다.
// 루트부터 시작해 연결된 모든 정점에 현재 깊이와 부모 값을 넣고, 아래로 연결된 정점의 배열을 모두 탐색한다.
// 이후, 주어진 두 정점의 공통 조상을 찾기 위해 LCA 알고리즘을 사용한다.
// 트리에서 두 정점을 같은 깊이로 맞춰주고, 같지 않다면 더 깊이 있는 정점을 부모 배열로 올리면서 깊이를 맞춰준다.
// 같은 깊이의 두 정점을 부모로 하나씩 올리며 같은 값을 가지는 공통 조상을 찾는다.
public class Main11437 {
    static Parent[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new Parent[N + 1];

        // 각 정점에서 가지는 간선 리스트 배열
        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 양방향 저장
            list[from].add(to);
            list[to].add(from);
        }

        // 루트의 정점
        parents[1] = new Parent(1, 0);
        // 1을 시작으로 dept 1부터 연결된 모든 배열 갱신
        find(1, 1, list);

        StringBuilder result = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 가장 가까운 공통 조상을 찾는 LCA
            int answer = lca(from, to);
            result.append(answer).append('\n');
        }

        System.out.println(result);
    }

    private static void find(int number, int dept, List<Integer>[] list) {
        // 연결된 간선 중에서 연결되지 않은 정점 연결하기
        for (Integer n : list[number]) {
            if (parents[n] == null) {
                // n 의 깊이는 dept, 부모 값은 number
                parents[n] = new Parent(number, dept);
                find(n, dept + 1, list);
            }
        }
    }

    private static int lca(int a, int b) {
        // 둘의 dept가 같을 때 까지 반복
        while (parents[a].dept != parents[b].dept) {
            if (parents[a].dept > parents[b].dept) {
                // a가 더 아래의 dept 이므로, a를 부모 값으로 갱신
                a = parents[a].number;
            } else {
                b = parents[b].number;
            }
        }

        // 같은 dept에서 공통 조상을 찾아나간다.
        while (a != b) {
            a = parents[a].number;
            b = parents[b].number;
        }
        return a;
    }

    static class Parent {
        int number, dept;

        public Parent(int number, int dept) {
            this.number = number;
            this.dept = dept;
        }
    }
}

