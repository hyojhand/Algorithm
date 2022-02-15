package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int number = 1;
        int x = (N / 2);
        int y = (N / 2);
        int level = 1;

        while (true) {
            //up
            for(int i = 0; i < level; i++) {
                arr[x][y] = number++;
                x--;
            }
            if((number-1) == N*N) break;
            //right
            for(int i  = 0; i < level; i++) {
                arr[x][y] = number++;
                y++;
            }
            level++;
            // down
            for(int i = 0; i < level; i++) {
                arr[x][y] = number++;
                x++;
            }
            //left
            for(int i = 0; i < level; i++) {
                arr[x][y] = number++;
                y--;
            }
            level++;
        }

        int row = 0;
        int col = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == num) {
                    row = i+1;
                    col = j+1;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
        System.out.println(row + " " + col);


    }
}
