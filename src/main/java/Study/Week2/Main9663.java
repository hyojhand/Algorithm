package Study.Week2;

import java.io.*;

public class Main9663 {
    static int N;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        find(1);

        System.out.println(count);
        
    }

    public static void find(int row) {
        for(int i  = 1; i < row-1; i++) {
            if(arr[row-1] == arr[i] || (row-1)-i == Math.abs(arr[row-1] - arr[i])) return;
        }

        if(row > N) {
            count++;
            return;
        }

        for(int i = 1; i <= N; i++) {
            arr[row] = i;
            find(row+1);
        }

    }
}
