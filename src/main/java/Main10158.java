import java.io.*;
import java.util.StringTokenizer;

public class Main10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int nx = (x + t) % (w * 2);
        if (nx > w) {
            nx = w * 2 - nx;
        }

        int ny = (y + t) % (h * 2);
        if (ny > h) {
            ny = h * 2 - ny;
        }

        sb.append(nx).append(" ").append(ny);
        System.out.println(sb);


    }
}
