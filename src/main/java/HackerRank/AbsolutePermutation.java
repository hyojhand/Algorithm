package HackerRank;

import java.util.*;
import java.util.stream.Collectors;

// Absolute Permutation
// N개의 숫자가 각 자리수(1~N)까지 뺏을 때의 절대값이 모두 K인 순열을 구하는 문제이다.
// 구할 수 없다면 -1을 출력한다.
// |permutations[a] - i| = k
// 먼저, K가 0이면 모든 값은 각 자리수에 해당하므로 바로 리턴해준다.
// K가 0이 아니라면, 이미 선택된 값을 처리하기 위한 배열로 방문 처리를 해준다.
// 2가지 경우의 수로 나눠 탐색한다.
// 1) permutations[a] = i - k
// 2) permutations[a] = k + i
// 첫번째 값, 두번째 값 순으로 범위내에 있으며 선택되지 않았다면 값을 갱신하고 방문처리해준다.
// 모두 만족하지 못하면 충족하는 순열이 없으므로 -1을 반환한다.
class AbsolutePermutation {
    public static List<Integer> absolutePermutation(int n, int k) {
        // 부분 수열 배열
        int[] permutations = new int[n + 1];

        // K가 0이면 각 자리수의 값이 배열 값이 된다.
        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                permutations[i] = i;
            }

            // 0을 제외한 배열을 리스트로 변경해 반환
            return Arrays.stream(permutations)
                    .filter(num -> num != 0)
                    .boxed()
                    .collect(Collectors.toList());
        }

        // 이미 선택된 값을 처리하기 위한 배열
        boolean[] visited = new boolean[n + 1];

        // 1부터 N까지 탐색
        for (int i = 1; i <= n; i++) {
            // 2가지 경우의 수로 확인
            int first = i - k;
            int second = k + i;

            // 첫번째 값이 범위내에 있으면서 선택되지 않은 값이라면
            if (first > 0 && first <= n && !visited[first]) {
                visited[first] = true;
                permutations[i] = first;
            }
            // 두번째 값이 범위내에 있으면서 선택되지 않은 값이라면
            else if (second > 0 && second <= n && !visited[second]) {
                visited[second] = true;
                permutations[i] = second;
            }
            // 선택할 수 있는 값이 없다면 -1 반환
            else {
                List<Integer> result = new ArrayList<>();
                result.add(-1);
                return result;
            }
        }

        // 0을 제외한 배열을 리스트로 변경해 반환
        return Arrays.stream(permutations)
                .filter(num -> num != 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
