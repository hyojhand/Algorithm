package HackerRank;

import java.util.*;

/**
 * 리스트로 주어진 숫자들에서 하나를 제외하고 나머지 숫자들을 1, 2, 5 중 하나를 선택해 모두 더할 수 있다.
 * 이때, 모든 수가 같아지기 위해 숫자를 더하는 최소값을 구하는 문제이다.

 * 1) 먼저, 숫자 범위가 최대 10,000 이므로 DP 배열을 최대 크기로 초기화한다.
 * DP 배열에 최대값으로 초기화하고, 1,2,5만 사용할 수 있으므로, DP[1], DP[2], DP[5]를 1로 갱신해준다.

 * 2) 입력으로 주어진 숫자에서 최소값을 구한다.

 * 하나의 숫자를 제외한 나머지 모든 수를 더하는 것을 반대로 하나의 숫자만 1,2,5 중에 하나로 빼주는 것과 같다는 아이디어를 떠올리기 어려웠다.
 * 각 값에 최소값을 뺀 숫자가 되기 위해 총 몇번의 연산으로 빼주는 것이 최소값인지 다이나믹 프로그래밍을 사용한다.

 * 3) 리스트를 반복하며 각 값에 최소값을 뺀 값에 DP를 사용한다.

 * 4) 단, [1,4,4] 같은 배열처럼 무조건 최소값을 뺀 값이 목표가 아닌
 * 최소값을 뺀 값에 1, 2를 더했을 때의 최소값도 구해보고 그 중에 가장 최소값을 구해준다.
 * (3부터는 1 + 2 이므로 2가 차이나서 최소값이 될 수 없다.)

 * 즉, 리스트를 반복하며 최소값을 뺀 값에 K를 [0,1,2] 만큼 더해주는 반복문의 값을 목표로 다이나믹 프로그래밍을 사용해 최소값을 구한다.
 */
class Equal {
    static int[] dp;

    public static int equal(List<Integer> arr) {
        // 최소값 탐색
        int min = Integer.MAX_VALUE;
        for (Integer number : arr) {
            min = Math.min(min, number);
        }

        // 숫자의 범위가 최대 10,000 이므로 DP 배열 최대 크기로 초기화
        dp = new int[10001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 1,2,5를 사용할 수 있으므로 각 dp 배열을 초기화
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;

        // 최대 결과값
        int answer = Integer.MAX_VALUE;
        // 0,1,2, 를 더했을 때 하나의 차이로 최소값이 달라질 수 있으므로 각 값에 0,1,2를 각각 더하며 탐색
        for (int k = 0; k < 3; k++) {
            // 총 경우의 개수
            int sum = 0;
            for (Integer number : arr) {
                // 최소값을 빼고 K 값을 더한 숫자
                int goalNumber = number - min + k;
                // 해당 숫자까지 가는데 필요한 dp 값 더하기
                sum += find(goalNumber);
            }
            // 최종 최소값
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    private static int find(int number) {
        if (dp[number] == Integer.MAX_VALUE) {
            if (number > 1) {
                dp[number] = Math.min(dp[number], find(number - 1));
            }

            if (number > 2) {
                dp[number] = Math.min(dp[number], find(number - 2));
            }

            if (number > 5) {
                dp[number] = Math.min(dp[number], find(number - 5));
            }

            dp[number]++;
        }

        return dp[number];
    }
}