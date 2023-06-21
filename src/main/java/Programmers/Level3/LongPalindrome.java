package Programmers.Level3;

// 프로그래머스 - 가장 긴 팰린드롬
// a ~ b 사이의 수가 팰린드롬인지 나타내는 boolean 배열 dp[a][b]을 정의하고,
// 1부터 길이 len 까지 2중 for문으로 팰린드롬 수라면, 그 길이가 최대가 되는 값을 구한다.
// 팰린드롬을 구할 때, 처음 방문하는 구간이라면 visited 배열로 방문처리를 해주고, 이후에는 바로 결과를 반환하도록 한다.
//
// 3가지 경우의 수로 나눠 팰린드롬인지 확인한다.
// 1) a = b 인 경우, 한 자리 수이므로 무조건 팰린드롬이 되어 true로 갱신하고 return
// 2) a + 1 = b - 1 인 경우, 붙어있는 수이기 때문에, 둘이 같다면 팰린드롬이 된다.
// 3) 나머지경우는 a와 b의 수가 같고, 그 사이의 인덱스 a+1, b-1 이 팰린드롬이라면 지금 구간도 팰린드롬이 된다.
public class LongPalindrome {
    boolean[][] visited, dp;
    String value;

    public int solution(String s) {
        value = s;
        int len = s.length();
        dp = new boolean[len + 1][len + 1];
        visited = new boolean[len + 1][len + 1];

        int answer = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (isPalindrome(i, j)) {
                    answer = Math.max(answer, Math.abs(i - j) + 1);
                }
            }
        }

        return answer;
    }


    private boolean isPalindrome(int a, int b) {
        if (!visited[a][b]) {
            visited[a][b] = true;

            // 홀수일 때, 같은 위치
            if (a == b) {
                dp[a][b] = true;
                return dp[a][b];
            }

            // 붙어있는 수
            if (a + 1 == b && b - 1 == a) {
                if (value.charAt(a - 1) == value.charAt(b - 1)) {
                    dp[a][b] = true;
                }

                return dp[a][b];
            }

            if (value.charAt(a - 1) == value.charAt(b - 1)
                    && isPalindrome(a + 1, b - 1)) {
                dp[a][b] = true;
            }
        }

        return dp[a][b];
    }
}
