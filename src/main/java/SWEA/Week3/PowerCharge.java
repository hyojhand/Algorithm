package SWEA.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class PowerCharge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        int[] dx = {0, 0, 1, 0, -1}; // 고정, 상, 우, 하, 좌
        int[] dy = {0, -1, 0, 1, 0};

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int A_x = 0;
            int A_y = 0;
            int B_x = 9;
            int B_y = 9;
            int charge = 0;

            int[][] move = new int[2][M]; // move[0] A move[1] B

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    move[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] BC = new int[A][4]; // X, Y, C, P
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    if (j == 0 || j == 1) {
                        BC[i][j] = Integer.parseInt(st.nextToken()) - 1;
                    } else {
                        BC[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }


            for (int i = 0; i <= M; i++) {
                if (i != 0) {
                    A_x = A_x + dx[move[0][i - 1]];
                    A_y = A_y + dy[move[0][i - 1]];
                    B_x = B_x + dx[move[1][i - 1]];
                    B_y = B_y + dy[move[1][i - 1]];
                }

                int[] A_can_charge = new int[A];
                int[] B_can_charge = new int[A];
                for (int b = 0; b < A; b++) {
                    if ((Math.abs(BC[b][0] - A_x) + Math.abs(BC[b][1] - A_y)) <= BC[b][2]) {
                        A_can_charge[b] = BC[b][3];
                    }

                    if ((Math.abs(BC[b][0] - B_x) + Math.abs(BC[b][1] - B_y)) <= BC[b][2]) {
                        B_can_charge[b] = BC[b][3];
                    }
                }


                int max = 0;
                for (int k = 0; k < A; k++) {
                    for (int l = 0; l < A; l++) {
                        if (A_can_charge[k] == B_can_charge[l]) {
                            if (A == 1) {
                                max = A_can_charge[k];
                            }
                            if (k != l) {
                                max = Math.max(max, A_can_charge[k] + B_can_charge[l]);
                            }
                        } else {
                            max = Math.max(max, A_can_charge[k] + B_can_charge[l]);
                        }
                    }
                }

                charge += max;

            }

            tc++;
            sb.append("#").append(tc).append(" ").append(charge).append('\n');

        }

        System.out.println(sb);
    }
}
