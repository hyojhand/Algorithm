package Study.Week1;

import java.io.*;
import java.util.ArrayList;

public class Main2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int first = Integer.parseInt(br.readLine());

        ArrayList<Integer> Max_list = new ArrayList<>();
        int max = 0;

        for (int i = 1; i <= first; i++) {
            int second = i;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(first);
            list.add(second);

            int count = 2;

            while (true) {
                int num = list.get(list.size() - 2) - list.get(list.size() - 1);
                if (num < 0) break;
                list.add(num);
                count++;
            }

            if (max < count) {
                max = count;
                Max_list = list;
            }
        }

        sb.append(max).append('\n');
        for (int i = 0; i < Max_list.size(); i++) {
            sb.append(Max_list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
