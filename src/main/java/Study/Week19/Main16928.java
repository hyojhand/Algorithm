package Study.Week19;

import java.io.*;
import java.util.*;

// 뱀과 사다리 게임
public class Main16928 {
    static int[] move,game;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        move = new int[101];
        game = new int[101];

        for(int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }

        bfs();
        System.out.println(game[100]);
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        game[1] = 1;
        boolean[] check = new boolean[101];
        check[1] = true;

        int count = 0;
        while(!que.isEmpty()) {

            int size = que.size();
            count++;
            for (int i = 0; i < size; i++) {

                int t = que.poll();

                for (int k = 1; k <= 6; k++) {
                    int num = t + k;
                    if (num > 100) continue;

                    if (!check[num]) {
                        game[num] = count;
                        check[num] = true;
                        if (move[num] != 0) {
                            game[move[num]] = count;
                            que.offer(move[num]);
                        } else {
                            que.offer(num);
                        }
                    }
                }

                if (game[100] != 0) return;
            }
        }
    }
}

