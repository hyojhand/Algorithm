package Study.Week5;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        for(int i = 0 ; i < N; i++) {
            hs.add(br.readLine());
        }

        String[] arr = new String[M];
        for(int i = 0; i < M; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < M; i++) {
            if(hs.contains(arr[i])) {
                count++;
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
