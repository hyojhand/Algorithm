package SWEA.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Battlefield {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 총 반복횟수 카운트
        int total = Integer.parseInt(br.readLine());
        int total_count = 0;
        while (total_count < total) {

            // 맵의 크기 입력
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 맵의 요소 저장할 배열생성
            char[][] map = new char[H][W];
            int tank_x = 0;
            int tank_y = 0;
            String tank_dir = "";

            // 맵 입력받으면서 탱크일때, 탱크의 위치와 방향 저장
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);

                    if (str.charAt(j) == 'v') {
                        map[i][j] = '.';
                        tank_x = i;
                        tank_y = j;
                        tank_dir = "down";
                    } else if (str.charAt(j) == '^') {
                        map[i][j] = '.';
                        tank_x = i;
                        tank_y = j;
                        tank_dir = "up";
                    } else if (str.charAt(j) == '<') {
                        map[i][j] = '.';
                        tank_x = i;
                        tank_y = j;
                        tank_dir = "left";
                    } else if (str.charAt(j) == '>') {
                        map[i][j] = '.';
                        tank_x = i;
                        tank_y = j;
                        tank_dir = "right";
                    }

                }
            }

            // 사용자가 넣을 입력의 개수 N
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            char[] input_arr = new char[N];
            for (int i = 0; i < N; i++) {
                input_arr[i] = input.charAt(i);
            }

            // switch case로 각 명령어 수행
            int input_count = 0;
            while (input_count < N) {
                switch (input_arr[input_count]) {
                    case 'U':
                        tank_dir = "up";
                        if (tank_x - 1 >= 0 && map[tank_x - 1][tank_y] == '.') {
                            tank_x--;
                        }
                        break;
                    case 'D':
                        tank_dir = "down";
                        if (tank_x + 1 < H && map[tank_x + 1][tank_y] == '.') {
                            tank_x++;
                        }
                        break;
                    case 'L':
                        tank_dir = "left";
                        if (tank_y - 1 >= 0 && map[tank_x][tank_y - 1] == '.') {
                            tank_y--;
                        }
                        break;
                    case 'R':
                        tank_dir = "right";
                        if (tank_y + 1 < W && map[tank_x][tank_y + 1] == '.') {
                            tank_y++;
                        }
                        break;
                    case 'S':
                        if (tank_dir.equals("left")) {
                            int count = 1;
                            for (int i = 1; i <= tank_y; i++) {
                                if (map[tank_x][tank_y - count] == '*') {
                                    map[tank_x][tank_y - count] = '.';
                                    break;
                                } else if (map[tank_x][tank_y - count] == '#') {
                                    break;
                                }
                                count++;
                            }
                        } else if (tank_dir.equals("right")) {
                            int count = 1;
                            for (int i = tank_y; i < W - 1; i++) {
                                if (map[tank_x][tank_y + count] == '*') {
                                    map[tank_x][tank_y + count] = '.';
                                    break;
                                } else if (map[tank_x][tank_y + count] == '#') {
                                    break;
                                }
                                count++;
                            }
                        } else if (tank_dir.equals("up")) {
                            int count = 1;
                            for (int i = 1; i <= tank_x; i++) {
                                if (map[tank_x - count][tank_y] == '*') {
                                    map[tank_x - count][tank_y] = '.';
                                    break;
                                } else if (map[tank_x - count][tank_y] == '#') {
                                    break;
                                }
                                count++;
                            }
                        } else if (tank_dir.equals("down")) {
                            int count = 1;
                            for (int i = tank_x; i < H - 1; i++) {
                                if (map[tank_x + count][tank_y] == '*') {
                                    map[tank_x + count][tank_y] = '.';
                                    break;
                                } else if (map[tank_x + count][tank_y] == '#') {
                                    break;
                                }
                                count++;
                            }
                        }
                        break;
                }
                input_count++;
            }

            // 마지막 탱크위치 입력
            if (tank_dir.equals("right")) {
                map[tank_x][tank_y] = '>';
            } else if (tank_dir.equals("left")) {
                map[tank_x][tank_y] = '<';
            } else if (tank_dir.equals("up")) {
                map[tank_x][tank_y] = '^';
            } else if (tank_dir.equals("down")) {
                map[tank_x][tank_y] = 'v';
            }

            // 결과출력
            total_count++;
            sb.append("#").append(total_count).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
