package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 소용돌이 예쁘게 출력하기
public class Main1022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int arrx = Math.abs(r2-r1)+1;
        int arry = Math.abs(c2-c1)+1;

        int max = 0;
        int[][] arr = new int[arrx][arry];
        int x = 0;
        int y = 0;
        int num = 1;

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int level = 1;

        Loop:
        while(true) {
            int temp;
            if(level % 2 != 0) { // 우, 상
                temp = 0;
            } else { // 좌,하
                temp = 1;
            }
            for(int t = temp; t < 4; t+=2) {
                for (int i = 0; i < level; i++) {
                    if(x>=r1&&x<=r2&&y>=c1&&y<=c2) {
                        int tx = x-r1;
                        int ty = y-c1;
                        arr[tx][ty] = num;
                        max = Math.max(max,num);
                    }
                    x += dx[t];
                    y += dy[t];
                    num++;

                    if(arr[0][0] != 0 && arr[arrx-1][0] != 0 && arr[0][arry-1] != 0 && arr[arrx-1][arry-1] != 0) break Loop;
                }
            }
            level++;
        }

        int len_max = (max+"").length();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrx; i++) {
            for(int j = 0; j < arry; j++) {
                int len = len_max - (arr[i][j]+"").length();
                for(int k = 0; k < len; k++) {
                    sb.append(" ");
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
