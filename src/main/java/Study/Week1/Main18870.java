package Study.Week1;

import java.io.*;
import java.util.*;

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i);
        }

        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) {
                arr[i] = map.get(arr[i]);
            }
        }

        for (int num : arr) {
            sb.append(num).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
