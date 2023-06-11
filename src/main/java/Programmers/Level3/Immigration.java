package Programmers.Level3;

import java.util.*;

// Level3 - 입국심사
// 입력으로 주어진 심사 시간을 정렬하고, 최소시간, 최대시간을 지정 (최대시간은 가장 긴 시간 * n명)
// mid분에 몇명을 처리할 수 있는지 이분탐색한다.
class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;

        // 심사시간 오름차순 정렬
        Arrays.sort(times);

        long start = 0;
        long end = (long) n * times[times.length - 1]; // 최악의 시간

        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;

            // mid 분에 총 몇명을 처리할 수 있는지
            for (int time : times) {
                count += mid / time;
            }

            // n명보다 작으면 start는 mid + 1
            if (count < n) {
                start = mid + 1;
            } else {
                end = mid;
                answer = mid;
            }
        }

        return answer;
    }
}
