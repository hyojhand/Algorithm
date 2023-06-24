package Baekjoon.BFS;

import java.io.*;
import java.util.*;

// G4 이모티콘
// 현재 개수, 클립에 저장된 개수, 걸린 시간을 가지는 객체로 각 조건을 BFS 탐색한다.
// 현재 개수와 저장 개수를 2차원 배열로 방문처리하며 방문하지 않은 개수만 큐에 넣어준다.
public class Main14226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[2001][2001];
        int answer = 0;

        Queue<Imoticon> que = new LinkedList<>();
        que.offer(new Imoticon(1, 0, 0));

        while (!que.isEmpty()) {

            Imoticon current = que.poll();
            if (current.now == S) {
                answer = current.time;
                break;
            }

            if (visited[current.now][current.save]) continue;
            visited[current.now][current.save] = true;

            // 1. 클립보드로 복사
            que.offer(new Imoticon(current.now, current.now, current.time + 1));

            // 2. 화면에 붙여넣기
            if (current.save > 0 && current.now + current.save < 2000) {
                que.offer(new Imoticon(current.now + current.save, current.save, current.time + 1));
            }

            // 3. 이모티콘 중 하나 삭제
            if (current.now > 0) {
                que.offer(new Imoticon(current.now - 1, current.save, current.time + 1));
            }
        }

        System.out.println(answer);
    }

    static class Imoticon {
        int now, save, time;

        public Imoticon(int now, int save, int time) {
            this.now = now;
            this.save = save;
            this.time = time;
        }
    }
}

