package Study.Week2;

import java.io.*;

public class Main2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int sum = 0;
        int num = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            if (Math.abs(sum - 100) <= Math.abs(num - 100)) num = sum;
            else break;
        }
        System.out.println(num);
    }
}
