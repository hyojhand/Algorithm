package Study.Week12;

import java.io.*;

// 책 페이지
public class Main1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        int tc = 1;
        while(N > 0) {

            if(N % 10 != 9 && N >= 10) {
                int count = N%10+1;

                int num = N%10;
                while (num >= 0) {
                    arr[num]+= tc;
                    num--;
                }

                num = N/10;
                while(num != 0) {
                    arr[num % 10] += count*tc;
                    num = num/10;
                }
                N -= count;
            }

            int end = 9;
            if(N < 10) end = N%10;
            for(int k = 0; k <= end; k++) {
                arr[k] += (N / 10 + 1) * tc;
                if(k == 0) arr[k] -= tc;
            }

            tc *= 10;
            N = N/10;
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k <= 9; k++) {
            sb.append(arr[k]).append(" ");
        }

        System.out.println(sb);
    }
}
