package Baekjoon.Recursion;

import java.io.*;

// G5 별 찍기 10
public class Main2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new char[num][num];

        StringBuilder sb = new StringBuilder();

        star(0, 0, num, false);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void star(int x, int y, int num, boolean blank) {
        if (blank) {
            for (int i = x; i < x + num; i++) {
                for (int j = y; j < y + num; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (num == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = num / 3;
        int count = 0;
        for (int i = x; i < x + num; i += size) {
            for (int j = y; j < y + num; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
