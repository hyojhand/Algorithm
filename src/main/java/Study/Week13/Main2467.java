package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 용액
public class Main2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = N-1;

        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = N-1;
        while(a < b) {
            int num = Math.abs(arr[a] + arr[b]);
            if(num < min) {
                x = arr[a];
                y = arr[b];
                min = num;
            }

            if(arr[a]+arr[b] > 0) b--;
            else a++;
        }

        System.out.println(x + " " + y);
    }
}
