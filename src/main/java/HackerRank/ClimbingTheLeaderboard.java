package HackerRank;

/**
 * - 1 ≤ n ≤ 2 * 10 ^ 5
 * - 1 ≤ m ≤ 2 * 10 ^ 5
 * - 0 ≤ ranked[i] ≤ 10 ^ 9 for 0 ≤ i < n
 * - 0 ≤ player[j] ≤ 10 ^ 9 for 0 ≤ j < m
 *
 * 입력으로 순위 리스트 ranked 가 주어진다. 순위에 player의 점수가 들어오
 * 같은 점수라면 동일한 순위이기 떄문에 ranked 리스트의 중복을 제거하기 위해 stream의 distinct를 사용한다.
 * player 리스트로 입력되는 점수가 들어올 때마다 현재 순위에서 몇위가 되는지 확인한다.
 */

import java.util.*;
import java.util.stream.Collectors;

class ClimbingTheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // 중복 순위는 동일하기 때문에 중복 제거
        ranked = ranked.stream()
                .distinct()
                .collect(Collectors.toList());

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        // 입력으로 주어진 player 점수 비교
        for (Integer score : player) {
            int start = 0;
            int end = ranked.size();

            int mid = 0;
            while (start < end) {
                mid = (start + end) / 2;

                // mid 등수의 점수
                int rankScore = ranked.get(mid);

                // 같은 점수라면 바로 break
                if (rankScore == score) {
                    break;
                } else if (score < rankScore) {
                    // player 점수가 작다면 뒤를 탐색
                    start = mid + 1;
                } else {
                    // player 점수가 크다면 앞을 탐색
                    end = mid;
                }
            }

            int answer = mid;
            // mid 등수의 점수보다 작으면 등수는 mid + 1
            if (score < ranked.get(mid)) {
                answer++;
            }

            // mid는 리스트의 인덱스이므로(0부터 시작), 1등부터 시작하기 최종적으로 + 1 더한 실제 등수를 저장
            result.add(answer + 1);
        }

        return result;
    }
}