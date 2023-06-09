package Baekjoon.BruteForce;

import java.io.*;
import java.util.*;

// G2 청소년 상어
// 1) 상어가 최초 0,0 위치로 이동하면서 물고기 생존여부 갱신
// 2) 물고기리스트에 번호순대로 정렬된 순서대로 이동 (이때, 빈칸도 이동가능함을 놓쳤는데 주의하자)
// 3) 상어가 이동할 방향으로 가능한 위치로 이동하며 물고기 갱신
// 4) 상어가 이동할 곳이 없을 때 까지 계속 반복
// 리스트의 깊은 복사에 주의하자!!
public class Main19236 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                arr[i][j] = number;
                fishList.add(new Fish(i, j, number, dir, true));
            }
        }

        // 물고기 번호순으로 정렬
        Collections.sort(fishList, (o1, o2) -> {
            return o1.number - o2.number;
        });

        Fish fish = fishList.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, fish.number, fish.dir);
        fish.isAlive = false;
        arr[0][0] = -1;

        sharkMove(shark, arr, fishList);

        System.out.println(max);

    }

    private static void sharkMove(Shark shark, int[][] arr, List<Fish> fishList) {
        // 상어 최대값 계속 갱신
        max = Math.max(max, shark.sum);

        // 물고기 이동
        moveFish(arr, fishList);

        // 상어 이동
        for (int k = 1; k < 4; k++) {
            int nx = shark.x + dx[shark.dir] * k;
            int ny = shark.y + dy[shark.dir] * k;

            // 물고기가 있다면 이동
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] > 0) {
                // 배열 깊은 복사
                int[][] copyArr = getCopyArr(arr);

                // 리스트의 깊은 복사 주의!
//                List<Fish> copyFishList = new ArrayList<>(fishList);
                List<Fish> copyFishList = getCopyFishList(fishList);

                copyArr[shark.x][shark.y] = 0;
                Fish findFish = copyFishList.get(copyArr[nx][ny] - 1);

                Shark nextShark = new Shark(nx, ny, shark.sum + findFish.number, findFish.dir);
                findFish.isAlive = false;
                copyArr[nx][ny] = -1;
                sharkMove(nextShark, copyArr, copyFishList);
            }
        }
    }

    private static int[][] getCopyArr(int[][] arr) {
        int[][] copyArr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(arr[i], 0, copyArr[i], 0, 4);
        }
        return copyArr;
    }

    // 리스트 깊은 복사 실행!!
    static List<Fish> getCopyFishList(List<Fish> fishList) {
        List<Fish> copyList = new ArrayList<>();
        fishList.forEach(f -> copyList.add(new Fish(f.x, f.y, f.number, f.dir, f.isAlive)));
        return copyList;
    }

    private static void moveFish(int[][] arr, List<Fish> fishList) {
        // 물고기 이동
        for (Fish fish : fishList) {
            // 없는 물고기라면 continue
            if (!fish.isAlive) {
                continue;
            }

            // 다음 진행방향에서 이동가능할때 까지 탐색하며 한번 이동
            for (int k = 0; k < 8; k++) {
                int nextDir = (fish.dir + k) % 8;
                int nx = fish.x + dx[nextDir];
                int ny = fish.y + dy[nextDir];

                // 상어가 아니라면 위치변경
                if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] >= 0) {
                    // 빈 곳이면
                    if (arr[nx][ny] == 0) {
                        arr[fish.x][fish.y] = 0;
                    } else {
                        Fish findFish = fishList.get(arr[nx][ny] - 1);
                        findFish.x = fish.x;
                        findFish.y = fish.y;
                        arr[fish.x][fish.y] = findFish.number;
                    }

                    fish.x = nx;
                    fish.y = ny;
                    arr[nx][ny] = fish.number;
                    fish.dir = nextDir;
                    break;
                }
            }
        }
    }

    static class Shark {
        int x, y, sum, dir;

        public Shark(int x, int y, int sum, int dir) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dir = dir;
        }
    }

    static class Fish {
        int x, y, number, dir;
        boolean isAlive;

        public Fish(int x, int y, int number, int dir, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }
}

