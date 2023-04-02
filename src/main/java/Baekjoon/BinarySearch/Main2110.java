package Baekjoon.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// G4 공유기 설치 - 공유기간의 최소거리(1)과 최대거리 (마지막수 - 처음수)를 기준으로 이분탐색한다.
// mid의 수보다 커질때마다 공유기를 설치해나가고, 최소 설치개수 미만일때는 간격이 길었기때문에 end를 mid - 1로 간격을 줄이고,
// 이상일때는 설치간격 최대값을 찾기위해 start를 mid + 1로 하면서 간격을 늘려 최대값을 구한다.
public class Main2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int start = 1;
        int end = home[N - 1] - home[0];
        int distance;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int preHome = home[0];
            int count = 1;

            for (int i = 1; i < N; i++) {
                distance = home[i] - preHome;
                if (distance >= mid) {
                    count++;
                    preHome = home[i];
                }
            }

            if (count >= C) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(answer);
    }
}

