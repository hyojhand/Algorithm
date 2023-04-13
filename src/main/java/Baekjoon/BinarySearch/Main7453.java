package Baekjoon.BinarySearch;

import java.io.*;
import java.util.*;

// G2 합이 0인 네 정수
// 1. A+B 배열 C+D 배열을 구해서 오름차순 정렬
// 2. A+B 배열의 값들에서 -(마이너스)한 값과 C+D 배열의 값이 같다면 4개의 수의 합이 0이 된다.
// 3. -(A+B)의 값을 C+D 배열을 이분탐색하여 찾는다.
// 4. 해당 값을 가지는 lower bound, upper bound를 찾아 인덱스의 차이를 개수로 계산해야 한다.
// * 4000 C 4 의 경우 10,650,673,999,000 이므로 long 타입을 사용해야 한다.
public class Main7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // A,B의 합 배열
        int[] aPlusB = getSumNumbers(A, B, N);
        // C,D의 합 배열
        int[] cPlusD = getSumNumbers(C, D, N);

        // 오름차순 정렬
        Arrays.sort(aPlusB);
        Arrays.sort(cPlusD);

        long answer = 0;
        for (int number : aPlusB) {
            // -(A+B)의 값과 같은 C+D의 값을 가지는 (최대 인덱스 - 최소 인덱스) 개수 더하기
            answer += (upperBound(-number, cPlusD) - lowerBound(-number, cPlusD));
        }

        System.out.println(answer);
    }

    // 만족하는 값의 바로 다음 인덱스
    private static int upperBound(int number, int[] numbers) {
        int start = 0;
        int end = numbers.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (numbers[mid] <= number) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // 만족하는 값의 최소 인덱스
    private static int lowerBound(int number, int[] numbers) {
        int start = 0;
        int end = numbers.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (numbers[mid] < number) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // 두개의 배열을 합치고 정렬해서 반환
    private static int[] getSumNumbers(int[] arr, int[] otherArr, int N) {
        int[] numbers = new int[N * N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                numbers[index] = arr[i] + otherArr[j];
                index++;
            }
        }

        Arrays.sort(numbers);
        return numbers;
    }
}
