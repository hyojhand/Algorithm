package Baekjoon.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// G5 주사위
// 정육면체이기에 규칙이 존재한다.
// 3면을 볼 수 있는 위치 개수 : 가장 윗면의 모서리 4개
// 2면을 볼 수 있는 위치 개수 : (N-2) * 8 + 4 (모서리를 제외한 위,옆 선 4개씩 8개) + 아랫면의 모서리 4개)
// 1면을 볼 수 있는 위치 개수 : 5 * (N-2)^2 + (N-2) * 4 (5면의 테두리를 제외한 가운데 블럭 + 아랫면의 밑선 4개)
// 3면의 합이 최소가 되기 위해서 마주보고 있는 각 면의 최소값을 더한다.
// 2면의 합이 최소가 되기 위해서 마주보는 면만 아니면 인접할 수 있다.
// 1면은 가장 최소값을 구한다.
// k번째 값과 마주보는 면은 5 - k번째 값이다
// 만약 N이 1이라면, 전체 넓이에서 최대값 면 1개만 제외하고 반환한다.
public class Main1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long answer = getSurfaceArea(dice, N);
        System.out.println(answer);
    }

    private static long getSurfaceArea(int[] dice, int N) {
        // N이 1이라면, 최대값만 뺀 5면의 넓이 반환
        if (N == 1) {
            long sum = 0;
            int max = 0;
            for (int i = 0; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }

            return sum - max;
        }

        // 3면의 합 최소값
        long threeSurface = 0;
        for (int i = 0; i < 3; i++) {
            threeSurface += Math.min(dice[i], dice[5 - i]);
        }

        // 2면의 합 최소값
        int[] min = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = Math.min(dice[i], dice[5 - i]);
        }
        Arrays.sort(min);
        long twoSurface = min[0] + min[1];

        // 1면의 최소값
        long oneSurface = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            oneSurface = Math.min(oneSurface, dice[i]);
        }

        // 최종합 계산
        long answer = 0;
        answer += (threeSurface * 4);
        answer += (twoSurface * ((N - 2) * 8 + 4));
        answer += oneSurface * (5 * Math.pow(N - 2, 2) + (N - 2) * 4);
        return answer;
    }
}

