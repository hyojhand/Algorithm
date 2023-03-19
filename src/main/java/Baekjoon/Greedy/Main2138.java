package Baekjoon.Greedy;

import java.io.*;

// G5 전구와 스위치
// 왼쪽부터 비교해가면서, 처음 전구를 누르는 경우와 누르지 않는 경우로 나눈다.
// 이전 전구가 다르면 스위치를 누르고, 같으면 바로 넘어간다.
// 마지막 단계의 전구만 비교해서 같다면 최소값 갱신
public class Main2138 {
    private static final int LIGHT_ON = 1;
    private static final int LIGHT_OFF = 0;

    private static int[] resultLight;
    private static int N;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] light1 = new int[N]; // 첫번째 전구를 누르지 않은 버전
        int[] light2 = new int[N]; // 첫번째 전구를 누른 버전
        resultLight = new int[N];

        String lightInput = br.readLine();
        String resultInput = br.readLine();
        for (int i = 0; i < N; i++) {
            light1[i] = lightInput.charAt(i) - '0';
            light2[i] = lightInput.charAt(i) - '0';
            resultLight[i] = resultInput.charAt(i) - '0';
        }

        // 첫번째 전구를 누르지 않음
        moveSwitch(1, light1, 0);

        // 첫번째 전구를 누름
        pushSwitch(0, light2);
        moveSwitch(1, light2, 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void moveSwitch(int idx, int[] light, int pushCount) {
        // 이전 전구까지 맞춰놓고, 마지막 자리의 전구만 비교
        if (idx == N) {
            if (light[idx - 1] == resultLight[idx - 1]) {
                answer = Math.min(answer, pushCount);
            }

            return;
        }

        // 이전 전구가 다르다면 스위치 push, 같다면 바로 이동
        if (light[idx - 1] != resultLight[idx - 1]) {
            pushSwitch(idx, light);
            moveSwitch(idx + 1, light, pushCount + 1);
        } else {
            moveSwitch(idx + 1, light, pushCount);
        }
    }

    // 스위치 push
    private static void pushSwitch(int idx, int[] light) {
        if (idx - 1 >= 0) {
            light[idx - 1] = changeLightState(light[idx - 1]);
        }

        light[idx] = changeLightState(light[idx]);

        if (idx + 1 < N) {
            light[idx + 1] = changeLightState(light[idx + 1]);
        }
    }

    // 전구 상태 변환
    private static int changeLightState(int light) {
        return light == LIGHT_ON ? LIGHT_OFF : LIGHT_ON;
    }
}
