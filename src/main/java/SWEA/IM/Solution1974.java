package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int[][] arr = new int[9][9];

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isOk = true;


            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += arr[i][j];
                }
                if (sum != 45) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                for (int i = 0; i < 9; i++) {
                    int sum = 0;
                    for (int j = 0; j < 9; j++) {
                        sum += arr[j][i];
                    }
                    if (sum != 45) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (isOk) {
                int x = 0;
                int y = 0;
                for (int k = 0; k < 9; k++) {


                    int sum = 0;
                    for (int i = x; i < x + 3; i++) {
                        for (int j = y; j < y + 3; j++) {
                            sum += arr[i][j];
                        }
                    }
                    if (sum != 45) {
                        isOk = false;
                        break;
                    }
                    x += 3;
                    if (x >= 9) x = x % 9;
                    y += 3;
                    if (y >= 9) y = y % 9;

                }
            }

            int result;
            if (isOk) result = 1;
            else result = 0;

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }
}
