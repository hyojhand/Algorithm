package Baekjoon.DP;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// G4 전깃줄 - 왼쪽 전봇대의 수를 오름차순으로 정렬하고, dp[k]로 k번째까지 연결가능한 최대 수를 구한다.
// 가장 길게 연결할 수 있는 전깃줄 수를 전체 수에서 빼면 최소로 끊을 수 있는 수가 나온다.
public class Main2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] wire = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            wire[i] = new Node(left, right);
        }

        Arrays.sort(wire, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.left - o2.left;
            }
        });

        int[] dp = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int k = 0; k < i; k++) {
                if (wire[i].right > wire[k].right) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        int answer = N - max;
        System.out.println(answer);
    }

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
