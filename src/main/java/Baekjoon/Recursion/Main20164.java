package Baekjoon.Recursion;

import java.io.*;

// G5 홀수 홀릭 호석 - string으로 변환해서 길이 및 substring
public class Main20164 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        findOdd(num, checkOdd(num));
        System.out.println(min + " " + max);
    }

    public static void findOdd(int num, int odd_count) {
        int size = (int) (Math.log10(num) + 1);
        if (size == 1) {
            max = Math.max(max, odd_count);
            min = Math.min(min, odd_count);
            return;
        }

        if (size == 2) {
            int next_num = num / 10 + num % 10;
            findOdd(next_num, odd_count + checkOdd(next_num));
            return;
        }

        String str = Integer.toString(num);
        for (int i = 0; i <= size - 3; i++) {
            for (int j = i + 1; j <= size - 2; j++) {
                String num1 = str.substring(0, i + 1);
                String num2 = str.substring(i + 1, j + 1);
                String num3 = str.substring(j + 1, size);

                num = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
                findOdd(num, odd_count + checkOdd(num));
            }
        }
    }

    public static int checkOdd(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10) % 2;
            num /= 10;
        }
        return sum;
    }
}
