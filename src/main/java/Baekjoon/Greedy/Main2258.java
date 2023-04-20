package Baekjoon.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// G4 정육점 - 비용이 작은 순서, 무거운 순으로 정렬하고 비용이 작은 것 부터 더해간다.
// 이전 비용과 같다면 구매하고, 이전비용보다 비싸다면 해당 비용만 지불하고 나머지 무게는 계속 더해간다
// 최소값을 구할때까지 계속 계산하면서 최소값을 찾는다
public class Main2258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] meat = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            meat[i][0] = Integer.parseInt(st.nextToken());
            meat[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meat, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        int answer = Integer.MAX_VALUE;
        int buyWeight = 0;
        int money = 0;
        for (int i = 0; i < N; i++) {
            buyWeight += meat[i][0];

            if (i > 0 && meat[i - 1][1] == meat[i][1]) {
                money += meat[i][1];
            } else {
                money = meat[i][1];
            }

            if (buyWeight >= M) {
                answer = Math.min(answer, money);
            }

        }

        if (buyWeight < M) System.out.println(-1);
        else System.out.println(answer);
    }
}
