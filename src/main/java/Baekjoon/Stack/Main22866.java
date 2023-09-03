package Baekjoon.Stack;

import java.io.*;
import java.util.*;

// G3 탑 보기
// 좌,우로 높은 건물의 개수를 확인하고 가장 가까운 건물의 번호 최소값을 구한다.
// 좌측은 순서대로 스택에 넣고, 우측은 뒤에서 부터 탐색하며 스택에 넣는다.
// 현재 위치의 높이보다 작은 건물의 높이는 모두 제거해주고, 각 스택의 개수와 근접한 거리도 배열로 저장해준다.
// 이때, 아예 높은 건물이 없는 경우도 있으므로 가까운 건물의 위치를 최초 -100000으로 초기화해준다.
public class Main22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N + 1];
        int[] count = new int[N + 1];
        int[] nearIndex = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
            nearIndex[i] = -100000; // 아예 없는 경우 0으로 되는 것을 방지하기 위해 초기화
        }

        // left
        Stack<Building> leftBuildings = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!leftBuildings.isEmpty() && leftBuildings.peek().height <= buildings[i]) {
                leftBuildings.pop();
            }
            int size = leftBuildings.size();
            if (size > 0) {
                nearIndex[i] = leftBuildings.peek().index;
            }
            count[i] = size;

            leftBuildings.push(new Building(buildings[i], i));
        }

        // right
        Stack<Building> rightBuildings = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!rightBuildings.isEmpty() && rightBuildings.peek().height <= buildings[i]) {
                rightBuildings.pop();
            }

            int size = rightBuildings.size();
            if (size > 0 && rightBuildings.peek().index - i < i - nearIndex[i]) {
                nearIndex[i] = rightBuildings.peek().index;
            }
            count[i] += size;

            rightBuildings.push(new Building(buildings[i], i));
        }


        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(count[i]);
            if (count[i] > 0) {
                answer.append(" ").append(nearIndex[i]);
            }
            answer.append('\n');
        }

        System.out.println(answer);
    }

    static class Building {
        int height, index;

        public Building(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}

