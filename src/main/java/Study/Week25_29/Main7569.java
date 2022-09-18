package Study.Week25_29;

import java.io.*;
import java.util.*;
// 토마토
public class Main7569 {
    static int[][][] arr;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static boolean[][][] check;
    static Queue<Point> que = new LinkedList<>();
    static int total,M,N,H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][M][H];
        check = new boolean[N][M][H];

        total = 0;
        int no = 0;
        int emp = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l < M; l++) {
                    arr[j][l][i] = Integer.parseInt(st.nextToken());
                    if(arr[j][l][i] == 1) {
                        que.offer(new Point(j,l,i));
                        check[j][l][i] = true;
                    }

                    if(arr[j][l][i] == 0) no++;
                    if(arr[j][l][i] == -1) emp++;
                }
            }
        }

        if(no == 0) System.out.println(0);
        else {
            int result = find();
            if((total+emp) == N*M*H) System.out.println(result);
            else System.out.println(-1);
        }

    }

    static int find() {
        int count = 0;

        while(!que.isEmpty()) {
            int size = que.size();
            count++;
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                total++;

                for (int k = 0; k < 6; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    int nz = p.z + dz[k];

                    if (nx>=0&&ny>=0&&nz>=0&& nx<N && ny<M && nz<H && !check[nx][ny][nz] && arr[nx][ny][nz] == 0) {
                        que.offer(new Point(nx, ny, nz));
                        check[nx][ny][nz] = true;
                    }
                }
            }
        }

        return count-1;
    }


    static class Point {
        int x,y,z;
        public Point(int x,int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
