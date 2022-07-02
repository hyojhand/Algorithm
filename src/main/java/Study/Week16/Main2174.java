package Study.Week16;

import java.io.*;
import java.util.StringTokenizer;

// 로봇 시뮬레이션
public class Main2174 {
    static int[][] arr;
    static Point[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        arr = new int[A][B];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        robot = new Point[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = A - Integer.parseInt(st.nextToken());
            String func = st.nextToken();
            int num;
            switch (func) {
                case "E":
                    num = 1;
                    break;
                case "S":
                    num = 2;
                    break;
                case "W":
                    num = 3;
                    break;
                default:
                    num = 4;
                    break;
            }
            arr[x][y] = i+1;
            robot[i+1] = new Point(x,y,num);
        }

        int isError = 0;
        int err_robot = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String func = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());

            if(isError == 0) {
                Loop:
                for (int k = 0; k < repeat; k++) {
                    switch (func) {
                        case "R":
                            robot[idx].dir = robot[idx].dir + 1;
                            if(robot[idx].dir == 5) robot[idx].dir = 1;
                            break;
                        case "L":
                            robot[idx].dir = robot[idx].dir - 1;
                            if (robot[idx].dir == 0) robot[idx].dir = 4;
                            break;
                        default:
                            int dir = robot[idx].dir;
                            int x = robot[idx].x;
                            int y = robot[idx].y;

                            if(dir == 1) robot[idx].y += 1;
                            else if(dir == 2) robot[idx].x += 1;
                            else if(dir == 3) robot[idx].y -= 1;
                            else robot[idx].x -= 1;

                            if(robot[idx].x >= A || robot[idx].x < 0 || robot[idx].y >= B || robot[idx].y < 0) {
                                isError = 2;
                                err_robot = idx;
                                break Loop;
                            }

                            if (arr[robot[idx].x][robot[idx].y] > 0) {
                                isError = 1;
                                err_robot = idx;
                                break Loop;
                            }

                            arr[x][y] = 0;
                            arr[robot[idx].x][robot[idx].y] = idx;
                            break;
                    }
                }
            }
        }

        if(isError == 0) System.out.println("OK");
        else if(isError == 1) System.out.println("Robot " + err_robot + " crashes into robot " +  arr[robot[err_robot].x][robot[err_robot].y]);
        else if(isError == 2) System.out.println("Robot " + err_robot + " crashes into the wall");
    }

    static class Point {
        int x,y,dir;
        public Point(int x,int y,int dir) {
            this.x = x;
            this.y = y;
            this. dir = dir;
        }
    }
}
