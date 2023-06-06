package Programmers.Level3;

// 거스름돈
// 0은 무조건 나눠지므로 1이다
// money의 값부터 시작해서 구하는 수 n까지 money를 뺐을 때의 경우의 수를 더해주며 dp에 저장해나간다.
// 최종적으로 얻은 m의 dp 값이 정답이다
public class ChangeMoney {
    private final int MOD = 1000000007;
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int m : money) {
            for(int i = m; i <= n; i++) {
                dp[i] += dp[i - m] % MOD;
            }
        }

        return dp[n];
    }
}
