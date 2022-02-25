package Study.Week2;

import java.io.*;

public class Main2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(true) {
            if(N % 5 == 0) {
                count += N/5;
                break;
            }
            else {
                N -= 3;
                count++;
            }

            if(N<0) {
                count = -1;
                break;
            }

        }

        System.out.println(count);
    }

}
