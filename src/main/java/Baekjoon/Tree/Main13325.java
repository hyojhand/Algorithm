package Baekjoon.Tree;

import java.io.*;
import java.util.*;

// G3 이진 트리
// bottom-up 방식으로 인접한 2개의 리프노드 최대값을 부모 노드로 올리고, 낮은 값은 노드는 부족한 값만큼 더한다.
// 포화 이진트리를 1차원 배열로 변환하는 아이디어 (1부터 사용하여 레벨 단위 나누기로 쉽게 계산 가능)
public class Main13325 {
    private static int[] dp;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = (int) Math.pow(2, N + 1);

        int sum = 0;
        int[] weight = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < size; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }

        dp = new int[size];
        // 리프노드 레벨부터 부모 노드로 값 갱신
        for (int i = N; i > 0; i--) {
            find(i, weight);
        }

        // 전체 값 + 변화된 값으로 결과값 출력
        System.out.println(sum + answer);
    }

    private static void find(int level, int[] weight) {
        for (int i = (int) Math.pow(2, level); i < Math.pow(2, level + 1); i += 2) {
            // 리프도느부터 더해온 값에 현재 값을 추가해 왼쪽,오른쪽 노드의 dp값 갱신
            dp[i] += weight[i];
            dp[i + 1] += weight[i + 1];

            int max = Math.max(dp[i], dp[i + 1]);
            int min = Math.min(dp[i], dp[i + 1]);

            // 최대값에서 최소값을 뺀만큼은 해당 노드에서 더하기
            answer += (max - min);
            // 부모 노드에게 최대값 전달
            dp[i / 2] = max;
        }
    }
}
