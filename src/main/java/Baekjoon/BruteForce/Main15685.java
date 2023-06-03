package Baekjoon.BruteForce;

import java.io.*;
import java.util.*;

// G4 드래곤 커브
// 방향으로 이동하면서 계속 점을 찍지 않고, 방향만 저장해놓은 이후 한번에 방문표시를 해준다.
// 방향을 리스트에 넣고, 현재 가진 크기부터 0번째까지 역순으로 90도 회전한 방향을 리스트에 넣어준다.
// 이를 g단계만큼 반복하고 시작점으로 부터 방향만큼 이동한 점을 갱신해가며 방문 처리한다.
// 최종적으로 모든 배열을 확인하며 1x1 정사각형을 만족하는 4점이 방문했다면 답을 갱신한다
public class Main15685 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directs = getDragonCurveDirects(d, g);

            checkPoint(x, y, directs);

        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void checkPoint(int x, int y, List<Integer> directs) {
        board[x][y] = true;
        for (int direct : directs) {

            x = x + dx[direct];
            y = y + dy[direct];
            board[x][y] = true;
        }
    }

    private static List<Integer> getDragonCurveDirects(int d, int g) {
        List<Integer> directs = new ArrayList<>();
        directs.add(d);

        // g 단계까지 반복
        for (int i = 0; i < g; i++) {
            for (int k = directs.size() - 1; k >= 0; k--) {
                directs.add((directs.get(k) + 1) % 4);
            }
        }

        return directs;
    }
}

