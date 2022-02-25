package Study.Week2;

import java.io.*;

public class Main8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = i; j <= N; j++) {
                if(i*j > N) {
                    break;
                }
                else count++;
            }
        }

        System.out.println(count);

    }
}
