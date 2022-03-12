package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 4;
        while (tc > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int nx1 = Integer.parseInt(st.nextToken());
            int ny1 = Integer.parseInt(st.nextToken());
            int nx2 = Integer.parseInt(st.nextToken());
            int ny2 = Integer.parseInt(st.nextToken());

            if (nx2 < x1 || x2 < nx1 || ny2 < y1 || y2 < ny1) {
                sb.append("d").append('\n');
            } else if ((nx2 == x1 && (ny1 == y2 || ny2 == y1)) || (nx1 == x2 && (ny1 == y2 || ny2 == y1))) {
                sb.append("c").append('\n');
            } else if (nx2 == x1 || nx1 == x2 || ny1 == y2 || ny2 == y1) {
                sb.append("b").append('\n');
            } else {
                sb.append("a").append('\n');
            }
            tc--;
        }

        System.out.println(sb);
    }
}
