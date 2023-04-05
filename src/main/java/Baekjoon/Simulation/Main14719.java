package Baekjoon.Simulation;

import java.io.*;
import java.util.*;
// G5 빗물 - 각 벽마다 좌우측의 최대 높이 벽을 찾고, 좌우측 벽의 최소값과 차이를 더해간다.
public class Main14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 제일 좌측, 우측 벽은 제외
        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            int wall = arr[i];

            // 현재보다 왼쪽에 높은 벽 찾기
            for (int k = 0; k <= i; k++) {
                leftMax = Math.max(leftMax, arr[k]);
            }

            // 현재보다 오른쪽에 높은 벽 찾기
            for (int k = i; k < W; k++) {
                rightMax = Math.max(rightMax, arr[k]);
            }

            // 현재 벽보다 높은 벽이 양쪽에 있다면
            if (wall < Math.min(leftMax, rightMax)) {
                answer += (Math.min(leftMax, rightMax) - wall);
            }
        }

        System.out.println(answer);
    }
}

