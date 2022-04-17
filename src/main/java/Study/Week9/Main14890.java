package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 경사로
public class Main14890 {
    static int N,L;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            if(row_check(i)) result++;
            if(col_check(i)) result++;
        }
        System.out.println(result);
    }

    public static boolean row_check(int idx) {

        boolean[] check = new boolean[N];
        for(int i = 1; i < N; i++) {
            int dif = Math.abs(arr[idx][i] - arr[idx][i - 1]);

            if (dif > 1) return false;
            else if (dif == 1) {
                if (arr[idx][i] > arr[idx][i - 1]) {
                    for (int t = i - 1; t > i - 1 - L; t--) {
                        if (t < 0 || arr[idx][i - 1] != arr[idx][t] || check[t]) return false;
                        check[t] = true;
                    }
                } else {
                    for (int t = i; t < i + L; t++) {
                        if (t >= N || arr[idx][i] != arr[idx][t] || check[t]) return false;
                        check[t] = true;
                    }
                }
            }
        }

        return true;
    }

    public static boolean col_check(int idx) {

        boolean[] check = new boolean[N];
        for(int i = 1; i < N; i++) {
            int dif = Math.abs(arr[i][idx] - arr[i-1][idx]);

            if (dif > 1) return false;
            else if(dif == 1) {
                if (arr[i][idx] > arr[i - 1][idx]) {
                    for (int t = i - 1; t > i - 1 - L; t--) {
                        if (t < 0 || arr[i - 1][idx] != arr[t][idx] || check[t]) return false;
                        check[t] = true;
                    }
                } else {
                    for (int t = i; t < i + L; t++) {
                        if (t >= N || arr[i][idx] != arr[t][idx] || check[t]) return false;
                        check[t] = true;
                    }
                }
            }
        }

        return true;
    }
}

