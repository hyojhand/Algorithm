package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

// G3 나머지 합
// sum[A] = A 까지의 합으로, sum[A] = (sum[A-1] + arr[A]) % M 이다.
// A ~ B 구간의 % M == 0 이기위한 조건 : sum[A] - sum[B-1] % M == 0
// -> sum[A] % M - sum[B-1] % M == 0
// -> sum[A] % M == sum[B-1] % M
// 1) sum[A]가 0인 경우 자체로 % M을 만족하므로 개수를 더해준다.
// 2) 위의 조건을 만족하기 위해 나머지 값의 배열에 개수를 더해서, 자신을 제외하고 같은 나머지의 개수의 조합을 더해준다.
// 최대 가지수가 1,000,000 C 2 이므로, int 범위를 넘어간다
public class Main10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 총 개수
        long answer = 0;

        // sum[i] : i번까지 더한 값을 M으로 나눈 수
        // 1) sum[i]가 0인 값 = 1~i까지 % M 하면 0이된다.
        int[] sum = new int[N + 1];

        // 나머지의 개수를 저장하는 배열
        int[] mod = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;

            if (sum[i] == 0) {
                answer++;
            }

            mod[sum[i]]++;
        }

        // 2) sum[A] == sum[B-1] 인 값을 구하면 A~B까지 % M은 0이다.
        // 따라서, 자신을 제외하고 같은 나머지를 가지는 조합을 구한다 (A~B, B~A 는 같으므로 나누기 2)
        for (int i = 0; i < M; i++) {
            if (mod[i] > 1) {
                answer += (long) mod[i] * (mod[i] - 1) / 2;
            }
        }

        System.out.println(answer);
    }

}

