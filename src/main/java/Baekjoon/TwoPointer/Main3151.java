package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

// G4 합이 0
// 하나의 값을 선택하고 다음 인덱스 부터 start로 지정하여 이분 탐색
// 같은 값이라도 모두 다른 사람으로 생각하기 때문에, 같은 값이 나온 만큼 조합으로 계산해야한다!
// 경우의 수는 10000C3 = 166,616,670,000이므로 long타입을 사용해야한다.
public class Main3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(numbers);

        long answer = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] <= 0) {
                answer += search(numbers[i], i + 1, numbers);
            }
        }

        System.out.println(answer);
    }

    private static long search(int number, int index, int[] numbers) {
        int start = index;
        int end = numbers.length - 1;
        long count = 0;

        while (start < end) {
            int sum = number + numbers[start] + numbers[end];

            if (sum == 0) {
                int startCount = 1;
                int endCount = 1;

                // 시작과 끝이 같다면 더 이상 경우의 수가 없으므로, 차이만큼 조합 계산
                if (numbers[start] == numbers[end]) {
                    int dif = end - start;
                    count += (long) dif * (dif + 1) / 2;
                    break;
                }

                // 시작 수의 다음이 같다면, 같은 수 계산
                while (start + 1 < end && numbers[start] == numbers[start + 1]) {
                    startCount++;
                    start++;
                }

                // 마지막 수의 다음이 같다면, 같은 수 계산
                while (start < end - 1 && numbers[end] == numbers[end - 1]) {
                    endCount++;
                    end--;
                }

                // 경우의 수 더하기
                count += (long) startCount * endCount;
            }

            if (sum <= 0) {
                start++;
            } else {
                end--;
            }
        }

        return count;
    }
}
