package Study.Week1;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(list.size() - num, i);
        }

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }
}
