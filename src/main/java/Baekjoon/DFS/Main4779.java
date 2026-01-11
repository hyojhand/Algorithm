package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4779 {
    public static int NUMBER = 3;
    public static StringBuilder builder;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int total = (int) Math.pow(NUMBER, N);
            builder = new StringBuilder();

            dfs(total);

            System.out.println(builder);
        }
    }

    static void dfs(int to) {
        if(to == 1) {
            builder.append("-");
            return;
        }

        dfs (to / NUMBER);
        builder.append(" ".repeat(Math.max(0, to / NUMBER)));
        dfs(to / NUMBER);
    }
}

