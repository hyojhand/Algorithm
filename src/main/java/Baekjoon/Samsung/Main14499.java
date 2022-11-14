package Baekjoon.Samsung;

import java.io.*;
import java.util.*;
// G4 주사위 굴리기
public class Main14499 {
    static int N,M,K;
    static int[][] arr;
    static int[] dice;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[7];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            x = nx;
            y = ny;

            move(dir);
            if (arr[x][y] == 0) {
                arr[x][y] = dice[6];
            } else {
                dice[6] = arr[x][y];
                arr[x][y] = 0;
            }

            sb.append(dice[1]).append("\n");
        }

        System.out.println(sb);
    }

    static void move(int dir) {
        int[] temp = dice.clone();

        switch (dir) {
            case 1:
                dice[6] = temp[3];
                dice[3] = temp[1];
                dice[1] = temp[4];
                dice[4] = temp[6];
                break;
            case 2:
                dice[6] = temp[4];
                dice[4] = temp[1];
                dice[3] = temp[6];
                dice[1] = temp[3];
                break;
            case 3:
                dice[6] = temp[2];
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[5] = temp[6];
                break;
            default:
                dice[6] = temp[5];
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[5] = temp[1];
                break;
        }
    }
}
