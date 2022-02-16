package Study.Week1;

import java.io.*;

public class Main2635ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int first = Integer.parseInt(br.readLine());
        sb.append(first).append(" ");
        float s = (float) Math.ceil(first * 0.61803);
        int second = (int) s;
        sb.append(second).append(" ");

        int count = 2;
        int num = first-second;
        while(num >= 0) {
            count++;
            sb.append(num).append(" ");
            first = second;
            second = num;
            num = first-second;
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
