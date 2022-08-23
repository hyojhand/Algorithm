package SWEA.IM;

import java.io.*;

public class Solution4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            String str = br.readLine();
            int[][] arr = new int[4][14];
            boolean isErr = false;

            Loop:
            for (int i = 0; i < str.length(); i += 3) {
                String card = str.substring(i, i + 1);
                int num = Integer.parseInt(str.substring(i + 1, i + 3));
                switch (card) {
                    case "S":
                        if (arr[0][num] != 0) {
                            isErr = true;
                            break Loop;
                        }
                        arr[0][num]++;
                        break;
                    case "D":
                        if (arr[1][num] != 0) {
                            isErr = true;
                            break Loop;
                        }
                        arr[1][num]++;
                        break;
                    case "H":
                        if (arr[2][num] != 0) {
                            isErr = true;
                            break Loop;
                        }
                        arr[2][num]++;
                        break;
                    case "C":
                        if (arr[3][num] != 0) {
                            isErr = true;
                            break Loop;
                        }
                        arr[3][num]++;
                        break;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ");

            if (isErr) sb.append("ERROR");
            else {
                for (int i = 0; i < 4; i++) {
                    int sum = 0;
                    for (int j = 1; j <= 13; j++) {
                        if (arr[i][j] == 1) sum++;
                    }
                    sb.append(13 - sum).append(" ");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
