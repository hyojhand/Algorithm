package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 접두사 찾기 S2
public class Main14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] str = new String[N];
        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            String prefix = br.readLine();
            int length = prefix.length();
            for(int j = 0; j < N; j++) {
                if(str[j].length() < length) continue;

                String substring = str[j].substring(0, length);
                if(substring.equals(prefix)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
