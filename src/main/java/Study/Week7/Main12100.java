package Study.Week7;

import java.io.*;
import java.util.*;

public class Main12100 {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, arr);

        System.out.println(max);

    }


    public static void find(int dept, int[][] arr) {
        if (dept == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, arr[i][j]);
                }
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            find(dept + 1, game(k, arr));
        }

    }

    public static int[][] game(int mode, int[][] temp) {
        int[][] copy = new int[N][N];

        Queue<Integer> que = new LinkedList<>();
        switch (mode) {
            case 0:
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (temp[j][i] != 0) {
                            if (que.isEmpty()) que.offer(temp[j][i]);
                            else {
                                int num = que.poll();
                                if (num == temp[j][i]) copy[idx][i] = num * 2;
                                else {
                                    copy[idx][i] = num;
                                    que.offer(temp[j][i]);
                                }
                                idx++;
                            }
                        }
                    }
                    if (!que.isEmpty()) copy[idx][i] = que.poll();
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (temp[i][j] != 0) {
                            if (que.isEmpty()) que.offer(temp[i][j]);
                            else {
                                int num = que.poll();
                                if (num == temp[i][j]) copy[i][idx] = num * 2;
                                else {
                                    copy[i][idx] = num;
                                    que.offer(temp[i][j]);
                                }
                                idx++;
                            }
                        }
                    }
                    if (!que.isEmpty()) copy[i][idx] = que.poll();
                }
                break;
            case 2:
                for (int i = N - 1; i >= 0; i--) {
                    int idx = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (temp[j][i] != 0) {
                            if (que.isEmpty()) que.offer(temp[j][i]);
                            else {
                                int num = que.poll();
                                if (num == temp[j][i]) copy[idx][i] = num * 2;
                                else {
                                    copy[idx][i] = num;
                                    que.offer(temp[j][i]);
                                }
                                idx--;
                            }
                        }
                    }
                    if (!que.isEmpty()) copy[idx][i] = que.poll();
                }
                break;
            case 3:
                for (int i = N - 1; i >= 0; i--) {
                    int idx = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (temp[i][j] != 0) {
                            if (que.isEmpty()) que.offer(temp[i][j]);
                            else {
                                int num = que.poll();
                                if (num == temp[i][j]) copy[i][idx] = num * 2;
                                else {
                                    copy[i][idx] = num;
                                    que.offer(temp[i][j]);
                                }
                                idx--;
                            }
                        }
                    }
                    if (!que.isEmpty()) copy[i][idx] = que.poll();
                }
                break;
        }


        return copy;

    }


}
