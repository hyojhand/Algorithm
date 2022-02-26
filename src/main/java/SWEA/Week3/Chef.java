package SWEA.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Chef {
    static int[][] arr;
    static boolean[] check;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc < T) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            check = new boolean[N];
            min = Integer.MAX_VALUE;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            find(0,N,0);

            tc++;
            sb.append("#").append(tc).append(" ");
            sb.append(min).append('\n');
        }

        System.out.println(sb);

    }


    public static void find(int dept, int N,int x) {
        if(dept == N/2) {
            int food1 = 0;
            int food2 = 0;
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    if(check[i] && check[j]) {
                        food1 += arr[i][j];
                        food1 += arr[j][i];
                    }
                    else if(!check[i] && !check[j]) {
                        food2 += arr[i][j];
                        food2 += arr[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(food1 - food2));
            return;
        }


        for(int i = x; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                find(dept+1, N,i);
                check[i] = false;
            }
        }

    }

}
