package SWEA.Week4;

import java.io.*;

public class CardCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            tc++;
            sb.append("#").append(tc).append(" ");
            String str = br.readLine();
            int[][] arr = new int[4][14];

            boolean isError = false;
            Loop:
            for (int i = 0; i < str.length(); i += 3) {
                String s = str.substring(i,i+3);
                char card = s.charAt(0);
                int num = Integer.parseInt(s.substring(i,i+3));
//                char card = str.charAt(i);
//                int num = (str.charAt(i + 1)-'0')*10 + (str.charAt(i + 2)-'0');
                switch (card) {
                    case 'S':
                        if (arr[0][num] != 0) {
                            isError = true;
                            break Loop;
                        }
                        arr[0][num] = 1;
                        break;
                    case 'D':
                        if (arr[1][num] != 0) {
                            isError = true;
                            break Loop;
                        }
                        arr[1][num] = 1;
                        break;
                    case 'H':
                        if (arr[2][num] != 0) {
                            isError = true;
                            break Loop;
                        }
                        arr[2][num] = 1;
                        break;
                    case 'C':
                        if (arr[3][num] != 0) {
                            isError = true;
                            break Loop;
                        }
                        arr[3][num] = 1;
                        break;
                }
            }

            if (isError) sb.append("ERROR");
            else {
                for (int i = 0; i < 4; i++) {
                    int count = 13;
                    for (int j = 1; j < 14; j++) {
                        if (arr[i][j] == 1) count--;
                    }
                    sb.append(count).append(" ");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);

    }
}
