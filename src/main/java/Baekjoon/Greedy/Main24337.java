package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

// G3 가희와 탑
// 좌측에서 보이는 탑의 개수만큼 리스트에 저장 (마지막 건물의 높이는 a,b의 최대값으로 저장)
// 우측에서 보이는 탑의 개수는 a,b의 최대값을 제외한 나머지 개수만큼 저장
// 그 외 부족한 빌딩의 개수만큼 1로 추가 (단, 왼쪽에서 보는게 1개라면 최대값 다음의 남은 개수를 1로 추가)
public class Main24337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 건물 높이가 존재하지 않으면 -1
        if (N + 1 < a + b) {
            System.out.println(-1);
            return;
        }

        int max = Math.max(a, b);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < a; i++) {
            list.add(i);
        }

        list.add(max);

        for (int i = b - 1; i > 0; i--) {
            list.add(i);
        }

        if (a == 1) {
            while (list.size() < N) {
                list.add(1, 1);
            }
        } else {
            while (list.size() < N) {
                list.add(0, 1);
            }
        }

        for (int num : list) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}

