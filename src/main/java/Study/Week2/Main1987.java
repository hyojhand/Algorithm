package Study.Week2;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1987 {
    static int R;
    static int C;
    static boolean[][] check;
    static char[][] arr;
    static HashSet<Character> hs = new HashSet<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        check = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        check[0][0] = true;
        hs.add(arr[0][0]);
        find(1,0,0);

        System.out.println(max);

    }


    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    public static void find(int count,int x,int y) {

        for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if(!check[nx][ny] && !hs.contains(arr[nx][ny])) {
                    check[nx][ny] = true;
                    hs.add(arr[nx][ny]);
                    find(count + 1, nx,ny);
                    hs.remove(arr[nx][ny]);
                    check[nx][ny] = false;
                }
            }
        }

        max = Math.max(max, count);

    }
}
