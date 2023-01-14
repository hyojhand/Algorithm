package Baekjoon.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// G5 입국심사 - 최대값 : 가장 오래 걸리는 시간 * 사람 수, 각 시간으로 몇명을 해결할 수 있는지 더하면서 인원을 충족하는 최소시간 계산
public class Main3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(times);

        long start = 0;
        long end = (long) times[times.length - 1] * M;

        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}

