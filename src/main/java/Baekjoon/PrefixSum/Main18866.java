package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;
// G5 젊은 날의 생이여
// 임의의 젊은날의 행복도가 임의의 늙은날의 행복도보다 커야한다.
// 즉, N번째 날까지(젊은날) 행복도 최소값과 N+1번째 날부터 마지막날까지(늙은날)의 행복도 최대값을 저장한 배열을 비교
// 추가로, N번째 날까지 피로도 최대값이 N+1번째 날부터 마지막날까지의 피로도 최소값보다 작은 날의 최대 일을 구한다.
public class Main18866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] happy = new int[N];
        int[] tired = new int[N];

        // 행복도, 피로도 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            happy[i] = Integer.parseInt(st.nextToken());
            tired[i] = Integer.parseInt(st.nextToken());
        }

        int[][] young = new int[N][2]; // 젊은날 - 행복 최소값, 피로 최대값
        int minHappy = Integer.MAX_VALUE;
        int maxTired = Integer.MIN_VALUE;

        // 젊은날 계산 (첫째날부터 마지막날을 제외한 날까지 계산, 0은 무시하고 계산)
        for (int i = 0; i < N - 1; i++) {
            if (happy[i] != 0) {
                minHappy = Math.min(minHappy, happy[i]);
            }

            if (tired[i] != 0) {
                maxTired = Math.max(maxTired, tired[i]);
            }

            young[i][0] = minHappy;
            young[i][1] = maxTired;
        }

        int[][] old = new int[N][2]; // 늙은날 - 행복 최대값, 피로 최소값
        int maxHappy = Integer.MIN_VALUE;
        int minTired = Integer.MAX_VALUE;

        // 늙은날 계산 (마지막날부터 첫째날을 제외한 날까지 계산, 0은 무시하고 계산)
        for (int i = N - 1; i > 0; i--) {
            if (happy[i] != 0) {
                maxHappy = Math.max(maxHappy, happy[i]);
            }

            if (tired[i] != 0) {
                minTired = Math.min(minTired, tired[i]);
            }

            old[i][0] = maxHappy;
            old[i][1] = minTired;
        }

        int result = -1;
        // i번째 젊은날과 i+1번째부터 늙은날의 최소,최대값을 비교
        for (int i = 0; i < N - 1; i++) {
            if (young[i][0] > old[i + 1][0] && young[i][1] < old[i + 1][1]) {
                result = i + 1;
            }
        }

        System.out.println(result);
    }
}
