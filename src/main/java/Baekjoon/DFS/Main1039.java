package Baekjoon.DFS;

import java.io.*;
import java.util.*;

// G3 교환
// 숫자 N을 i번 인덱스와 j번 인덱스를 골라 K번 변경하면서 가장 최대값을 출력하는 문제이다.
// 숫자 N의 최대값이 1,000,000이므로, 자리수(M)는 7이 최대이다.
// DFS를 활용해 K번 도달했을 때 변경할 수 있는 최대값을 구한다.
// 앞자리에 0이 올 수 없는 조건을 제외하고 인덱스의 값을 바꾼 문자를 DFS 탐색하면서, K번째에 도달하면 최대값을 구해준다.
// 이때, 같은 단계에서 변경할 수 있는 수의 중복이 많이 일어나기 때문에 메모리 초과가 발생했고, 이를 방지하기 위해 방문처리를 해준다.
// 해당 단계(dept)에서 이미 DFS 탐색을 했던 숫자로 방문처리가 되어있다면 바로 리턴해주어 메모리 초과를 해결한다.
public class Main1039 {
    static boolean[][] visited;
    static int M, K;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        M = N.length();
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001][K + 1];

        dfs(0, N);

        System.out.println(answer);
    }

    private static void dfs(int dept, String N) {
        // 이미 방문했다면 return
        if (visited[Integer.parseInt(N)][dept]) {
            return;
        }

        visited[Integer.parseInt(N)][dept] = true;

        // 마지막 K번 수행했다면 return
        if (dept == K) {
            answer = Math.max(answer, Integer.parseInt(N));
            return;
        }

        // 첫 인덱스부터 가장 낮은 인덱스를 찾아본다.
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {

                // 첫 인덱스에 바꾸려는 값이 0은 올 수 없다
                if (i == 0 && N.charAt(j) == '0') {
                    continue;
                }

                dfs(dept + 1, swapString(N, i, j));
            }
        }
    }

    private static String swapString(String value, int index, int otherIndex) {
        char[] values = value.toCharArray();
        char temp = values[index];
        values[index] = values[otherIndex];
        values[otherIndex] = temp;
        return String.valueOf(values);
    }
}

