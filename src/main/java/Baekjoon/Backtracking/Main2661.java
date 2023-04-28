package Baekjoon.Backtracking;

import java.io.*;

// G4 좋은수열
public class Main2661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최소값 1로 시작
        find("1", N);
    }

    private static void find(String result, int N) {
        // 최초 완성된 수열이 최소값
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);
        }

        // 1 ~ 3을 추가했을 때 좋은 수열이라면 재귀
        for (int num = 1; num <= 3; num++) {
            if (isGoodSequence(result + num)) {
                find(result + num, N);
            }
        }
    }

    private static boolean isGoodSequence(String result) {
        int len = result.length();
        int start = len - 1;

        // 1자리 수부터 절반까지 비교하며 같은지 확인
        for (int i = 1; i <= len / 2; i++) {
            if (result.substring(start, len).equals(result.substring(start - i, len - i))) {
                return false;
            }

            // 시작점을 낮추며 한자리씩 늘려가기
            start--;
        }
        return true;
    }
}

