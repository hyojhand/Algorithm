package Programmers.Level3;

import java.util.*;

// 단속 카메라
// 마지막 지점을 기준으로 오름차순 정렬하고, 시작이 이전 끝보다 크다면 새로 카메라를 추가하며 마지막 값 갱신 - 그리디
public class EnforcementCamera {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int end = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > end) {
                end = route[1];
                answer++;
            }
        }

        return answer;
    }
}
