package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        int[][] arr = new int[300][300];
        int count = 1;
        int dept = 1;
        int y;

        while(count <= 40000) {
            y = dept;
            for(int i = 1; i < 1+dept; i++) {
                arr[i][y] = count++;
                y--;
            }

            dept++;
        }

//        int[][] arr = new int[300][300];
//        for(int i = 1; i < 300; i++) {
//            int sum = 0;
//            for(int j = 1; j <= i; j++) {
//                sum+=j;
//            }
//            arr[i][1] = sum;
//
//            int cnt = 0;
//            for(int j = 2; j < 300; j++) {
//                arr[i][j] = arr[i][j-1] + i + cnt;
//                cnt++;
//            }
//        }

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int a = 0;
            int b = 0;

            Loop:
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == p) {
                        a = i;
                        b = j;
                        break Loop;
                    }
                }
            }

            Loop:
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == q) {
                        a += i;
                        b += j;
                        break Loop;
                    }
                }
            }

            int result = arr[a][b];

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }
}
