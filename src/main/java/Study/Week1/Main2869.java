package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        double sum = A-B;
        int count = (int) Math.ceil((V-A) / sum);

        System.out.println(count+1);

    }
}
