package Study.Week11;

import java.io.*;
import java.util.StringTokenizer;
// 구슬탈출2
public class Main13460 {
    static int N,M;
    static int result = 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(-1,1,arr);

        if(result == 11) result = -1;
        System.out.println(result);
    }

    static void dfs(int pre_mode, int count, char[][] copy) {
        if(result < count) return;

        if(count > 10) {
            return;
        }

        for(int k = 0; k < 4; k++) {
            if(k == pre_mode) continue; // 같은 방향 탐색x

            char[][] tempArr = new char[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(copy[i], 0, tempArr[i], 0, M);
            }

            int move = move(k,tempArr);

            if(move == 1) {
                result = Math.min(count, result);
                return;
            } else if(move == -1) continue;

            dfs(k,count+1, tempArr);
        }

    }

    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int move(int mode,char[][] arr) {

        int cnt = 0; // 빠진 구슬 개수
        boolean flag = false; // 빨간구슬이 떨어졌는지

        if(mode < 2) { // 왼쪽 , 위
            for(int i = 1; i < N-1; i++) {
                for(int j = 1; j < M-1; j++) {
                    if(arr[i][j] == 'R' || arr[i][j] == 'B') {
                        int nx = i + dx[mode];
                        int ny = j + dy[mode];
                        while (arr[nx][ny] == '.') {
                            nx += dx[mode];
                            ny += dy[mode];
                        }

                        if(arr[nx][ny] == 'O') {
                            cnt++;
                            if(arr[i][j] == 'R') flag = true;
                            arr[i][j] = '.';
                            continue;
                        }

                        if(arr[nx-dx[mode]][ny-dy[mode]] != arr[i][j]) {
                            arr[nx - dx[mode]][ny - dy[mode]] = arr[i][j];
                            arr[i][j] = '.';
                        }

                    }
                }
            }
        } else { // 오른쪽, 아래
            for(int i = N-2; i >= 1; i--) {
                for(int j = M-2; j >= 1; j--) {
                    if(arr[i][j] == 'R' || arr[i][j] == 'B') {
                        int nx = i + dx[mode];
                        int ny = j + dy[mode];
                        while(arr[nx][ny] == '.') {
                            nx += dx[mode];
                            ny += dy[mode];
                        }

                        if(arr[nx][ny] == 'O') {
                            cnt++;
                            if(arr[i][j] == 'R') flag = true;
                            arr[i][j] = '.';
                            continue;
                        }

                        if(arr[nx-dx[mode]][ny-dy[mode]] != arr[i][j]) {
                            arr[nx - dx[mode]][ny - dy[mode]] = arr[i][j];
                            arr[i][j] = '.';
                        }

                    }
                }
            }
        }

        if(cnt == 2) return -1; // 둘다 -1
        if(cnt == 1) {
            if(flag) return 1; // 빨강만
            else return -1; // 파랑만 -1
        }

        return 0; // 둘다 아님
    }
}
