package Baekjoon.BruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// G4 고층건물 - 빌딩의 기울기를 비교해서 갱신해가는 기울기보다 크다면 볼 수 있는 것으로 판단
// visible[n] : n번째 빌딩에서 보이는 빌딩 수
public class Main1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 기울기 비교하여 볼 수 있는 빌딩 배열 반환
        int[] visible = compareSlope(buildings, N);

        // 최대값 stream 연산
        int answer = Arrays.stream(visible)
                .max()
                .orElse(0);

        System.out.println(answer);
    }

    private static int[] compareSlope(int[] buildings, int N) {
        int[] visible = new int[N];

        for (int i = 0; i < N - 1; i++) {
            // 바로 옆 빌딩은 무조건 보인다.
            visible[i] += 1;
            visible[i + 1] += 1;
            // 기울기 : y 증가량 / x 증가량(1)
            double slope = buildings[i + 1] - buildings[i];

            // 다다음 빌딩들의 기울기 비교
            for (int k = i + 2; k < N; k++) {
                double anotherSlope = (double) (buildings[k] - buildings[i]) / (k - i);

                // 기울기가 작으면 볼 수 없는 건물
                if (anotherSlope <= slope) {
                    continue;
                }

                // 볼 수 있다면, 마지막 기울기 갱신 및 빌딩 개수 추가
                slope = anotherSlope;
                visible[i]++;
                visible[k]++;
            }
        }

        return visible;
    }
}

