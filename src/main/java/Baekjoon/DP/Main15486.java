package Baekjoon.DP;

import java.io.*;
import java.util.*;

// G5 퇴사2
// N이 최대 1,500,000 이므로, N^2의 시간복잡도는 시간초과가 발생하게 되어 DP를 활용해 O(N)의 시간복잡도로 풀이한다.
// DP[a] : a일 까지 얻을 수 있는 최대 금액
// 입력으로 주어지는 상담 시간,금액을 배열로 저장한다.
// 먼저, 지금까지의 최대값과 오늘일 까지의 DP값을 비교해 최대값을 갱신한다.
// 오늘 있을 상담을 한다면, 금액을 받을 수 있는 날을 구하고, 그 날이 N이하(퇴사하기 전)인지 확인한다.
// 받을 수 있다면, 해당날의 DP값과 (지금까지의 최대값 + 오늘 상담한 비용)을 더한 값중에 최대값을 구해 갱신해준다.
// 마지막으로 모든 DP값을 탐색하며 가장 최대값을 탐색해 반환한다.
public class Main15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        // 입력으로 주어지는 상담 시간,금액을 배열로 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(time, cost);
        }

        // dp[a] : a일 까지 상담했을 때의 최대 금액
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            // 현재일에서 얻을 수 있는 최대금액
            max = Math.max(max, dp[i]);

            // i번째 상담을 했을 때, 금액을 받는 일자
            int next = i + meetings[i].time;
            // 퇴사하기 전에 금액을 받을 수 있다면
            if (next <= N) {
                // 그 날짜의 값과 (현재까지의 최대값 + 오늘 상담한 금액) 중에 최대값 갱신
                dp[next] = Math.max(dp[next], max + meetings[i].cost);
            }
        }

        int answer = 0;
        // 모든 날에서 상담 금액이 최대인 최대값 탐색
        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

    static class Meeting {
        int time, cost;

        public Meeting(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
}

