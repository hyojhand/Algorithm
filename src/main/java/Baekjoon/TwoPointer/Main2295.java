package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

// G4 세 수의 합
// 배열 내의 숫자를 만들 수 있는지 확인하기 위해 탐색
// 하나의 숫자를 지정하고 지정한 숫자의 인덱스(start)와 마지막 인덱스(end)를 이분탐색하며 만들 수 있는지 확인
public class Main2295 {
    static int[] numbers;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 숫자 오름차순 정렬
        Arrays.sort(numbers);

        // 배열이 가지는 숫자 K 를 만들 수 있는지 탐색
        for (int K : numbers) {
            // 중복이 가능하므로 시작부터 끝까지 모두 탐색한다. (숫자 1개, 시작할 인덱스, 만들 숫자 K)
            for (int j = 0; j < numbers.length; j++) {
                search(numbers[j], j, K);
            }
        }

        System.out.println(answer);
    }

    private static void search(int number, int index, int K) {
        int start = index;
        int end = numbers.length - 1;

        while (start <= end) {
            int sum = number + numbers[start] + numbers[end];
            // 지정한 숫자 1개와 start, end 인덱스의 숫자 합이 K라면 최대값 갱신 후 return
            if (sum == K) {
                answer = Math.max(answer, sum);
                return;
            }

            if (sum <= K) {
                start++;
            } else {
                end--;
            }
        }

    }
}
