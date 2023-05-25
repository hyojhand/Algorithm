package Baekjoon.BinarySearch;

import java.io.*;

// G2 K번째 수
// 생각하기 매우 어려웠던 문제
// N이 100000 이므로 N*N 배열을 만들어 정렬하면 시간초과가 발생한다.
// 배열을 만들지않고, 각 행에서 x보다 작은 수의 개수를 구하는 방법으로 이분탐색하여 구할 수 있다.
// K번째 수의 최대값은 K를 넘어가지 않기 때문에 마지막 end를 K로 지정한다.
// i번째 행에서 mid보다 작은 수의 개수는 mid / i 개이다.
// N보다 큰 수가 되면, 행렬의 열의 개수를 넘어가기 때문에 최소값을 선택한다.
public class Main1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int end = K;

        while (start < end) {
            int mid = (start + end) / 2;
            int count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min((mid / i), N);
            }

            if (count < K) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }

        System.out.println(start);
    }
}

