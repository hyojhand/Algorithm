package Baekjoon.DP;

import java.io.*;

// G5 암호코드
// 한 자리의 경우 1~9이면, 앞의 개수만큼 더한다.(0은 1로 초기화) 이후, 앞의 인덱스가 없으므로 바로 리턴한다.
// 첫번째 인덱스가 아니므로, 앞의 숫자를 10의 자리로 계산해서 해당 숫자가 10~26 사이라면, 한단계 더 앞의 인덱스에서 경우의 수도 더해준다.
public class Main2011 {
    private static final int MOD = 1000000;
    static int[] dp;
    static String value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        value = br.readLine();

        dp = new int[value.length() + 1];
        dp[0] = 1;

        int answer = find(value.length());
        System.out.println(answer);
    }

    private static int find(int number) {
        if (dp[number] == 0) {
            // 현재 인덱스의 숫자
            int now = value.charAt(number - 1) - '0';

            // 한 자리 경우의 수는 앞의 개수만큼 더해준다
            if (now >= 1 && now <= 9) {
                dp[number] += find(number - 1);
                dp[number] %= MOD;
            }

            // 1자리 수는 앞의 숫자가 없으므로 return
            if (number == 1) {
                return dp[number];
            }

            // 앞의 인덱스의 숫자
            int pre = value.charAt(number - 2) - '0';

            int sum = pre * 10 + now;
            // 앞의 숫자를 포함해서 10~26 사이일 때, 2자리 경우의 수도더해준다
            if (sum >= 10 && sum <= 26) {
                dp[number] += find(number - 2);
                dp[number] %= MOD;
            }
        }

        return dp[number];
    }
}

