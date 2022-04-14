package Study.Week9;

import java.io.*;
// 명제 증명
public class Main2224 {
    static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[59][59];

        for(int i = 0; i<59; i++) {
            for(int j = 0;j<59;j++) {
                if(i!=j) arr[i][j] = INF;
            }
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            int p = str.charAt(0)-65;
            int q = str.charAt(5)-65;
            arr[p][q] = 1;
        }

        for(int k = 0; k < 59; k++) {
            for(int i = 0; i < 59; i++) {
                for(int j = 0; j < 59; j++) {
                    arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < 59; i++) {
            for(int j = 0; j < 59; j++) {
                if(arr[i][j] > 0 && arr[i][j] != INF && i != j) {
                    count++;
                }
            }
        }
        sb.append(count).append('\n');

        for(int i = 0; i < 59; i++) {
            for(int j = 0; j < 59; j++) {
                if(arr[i][j] > 0 && arr[i][j] != INF && i != j) {
                    sb.append((char)(i+65)).append(" => ").append((char)(j+65)).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
