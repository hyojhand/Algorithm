package Study.Week2;

import java.io.*;

public class Main10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] arr = new Integer[26];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 97;
            if(arr[num] != null) {
                continue;
            }
            arr[num] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == null) {
                sb.append(-1).append(" ");
            } else {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb);

    }

}
