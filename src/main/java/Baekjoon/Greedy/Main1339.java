package Baekjoon.Greedy;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// G4 단어 수학
// 각 알파벳마다 자리수 만큼의 값을 배열에 더해나간다.
// 저장된 값을 내림차순으로 정렬하여 9부터 곱한 값을 더해주며 최대값 계산
public class Main1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 26개의 알파벳 위치값을 저장할 배열
        int[] alphabets = new int[27];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            for (int k = 0; k < word.length(); k++) {
                int index = word.charAt(k) - 'A';
                // 각 자리수만큼 값을 더하며 탐색
                alphabets[index] += Math.pow(10, word.length() - k - 1);
            }
        }

        // 값 순서로 내림차순 정렬
        List<Integer> sortedAlphabets = Arrays.stream(alphabets)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int value = 9;
        int answer = 0;
        // 높은 순서대로 9부터 차례로 곱해서 더해간다
        for (Integer number : sortedAlphabets) {
            answer += (number * value);
            value--;
        }

        System.out.println(answer);
    }
}
