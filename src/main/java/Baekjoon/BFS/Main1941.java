package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1941 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;
    static int[] checked;
    static Student[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;

        students = new Student[25];
        checked = new int[7];

        for(int i = 0; i < 5; i++) {
            String input = br.readLine();
            for(int j = 0; j < 5; j++) {
                students[i*5 + j] = new Student(i, j, input.charAt(j));
            }
        }

        combination(0, 0, 0);

        System.out.println(answer);
    }

    static void combination(int start, int cnt, int sCnt) {
        if(cnt - sCnt > 3) return;

        if(cnt == 7) {
            bfs();
            return;
        }

        for(int i = start; i < 25; i++) {
            checked[cnt] = i;
            combination(i + 1, cnt + 1, students[i].part == 'S' ? sCnt + 1 : sCnt);
        }
    }

    static void bfs() {
        boolean[][] visited = new boolean[5][5];

        int firstNum = checked[0];
        Student s = students[firstNum];
        visited[s.x][s.y] = true;
        Queue<Student> que = new LinkedList<>();
        que.offer(s);
        int sCnt = 0;
        int cnt = 0; // 인접한 여학생수

        while(!que.isEmpty()) {
            Student poll = que.poll();
            cnt++;
            if(poll.part == 'S') {
                sCnt++;
            }

            for(int k = 0; k < 4; k++) {
                int nx = poll.x + dx[k];
                int ny = poll.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;

                int nextNum = nx * 5 + ny;
                for(int t = 0; t < 7; t++) {
                    if(checked[t] == nextNum) {
                        visited[nx][ny] = true;
                        que.offer(students[nextNum]);
                        break;
                    }
                }
            }
        }

        if(cnt == 7 && sCnt >= 4) {
            answer++;
        }
    }

    static class Student {
        int x, y;
        char part;
        public Student(int x, int y, char part) {
            this.x = x ;
            this.y = y;
            this.part =part;
        }
    }
}
