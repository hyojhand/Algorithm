package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main17144 {
    static int N, M;
    static int[][] arr;
    static int[] clean_machine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        clean_machine = new int[2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    clean_machine[idx] = i;
                    idx++;
                }
            }
        }


        for (int i = 0; i < T; i++) {
            spread();
            clean();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }

        System.out.println(sum);

    }

    public static void clean() {
        for (int i = 0; i < 2; i++) {
            int clean_x = clean_machine[i];
            int clean_y = 1;
            int pre = 0;


            switch (i) {
                case 0:
                    for (int j = 1; j < M-1; j++) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_y++;
                    }
                    for(int j = clean_x; j > 0; j--) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_x--;
                    }
                    for(int j = M-1; j > 0; j--) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_y--;
                    }
                    for(int j = 0; j < clean_machine[i]; j++) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;
                        clean_x++;
                    }
                    break;
                case 1:
                    for (int j = 1; j < M-1; j++) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_y++;
                    }
                    for(int j = clean_x; j < N-1; j++) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_x++;
                    }
                    for(int j = M-1; j > 0; j--) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;

                        clean_y--;
                    }
                    for(int j = N-1; j > clean_machine[i]; j--) {
                        int next = arr[clean_x][clean_y];
                        arr[clean_x][clean_y] = pre;
                        pre = next;
                        clean_x--;
                    }
                    break;
            }
        }

    }


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void spread() {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] != -1) {
                            copy[nx][ny] += arr[i][j] / 5;
                            count++;
                        }
                    }
                    copy[i][j] -= (arr[i][j] / 5) * count;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] += copy[i][j];
            }
        }
    }


}
