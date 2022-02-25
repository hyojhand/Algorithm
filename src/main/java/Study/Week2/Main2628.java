package Study.Week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> row_list = new ArrayList<>();
        ArrayList<Integer> col_list = new ArrayList<>();

        row_list.add(0);
        col_list.add(0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cut = Integer.parseInt(st.nextToken());

            if (dir == 0) {
                row_list.add(cut);
            } else {
                col_list.add(cut);
            }
        }

        row_list.add(x);
        col_list.add(y);

        Collections.sort(row_list);
        Collections.sort(col_list);

        int max_row = 0;
        for (int i = 1; i < row_list.size(); i++) {
            max_row = Math.max(row_list.get(i) - row_list.get(i - 1), max_row);
        }
        int max_col = 0;
        for (int i = 1; i < col_list.size(); i++) {
            max_col = Math.max(col_list.get(i) - col_list.get(i - 1), max_col);
        }

        System.out.println(max_row * max_col);

    }
}
