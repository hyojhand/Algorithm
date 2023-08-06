package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

// G4 List of Unique Numbers
// 이미 사용된 숫자를 확인하는 visited 배열로 방문처리가 된 숫자가 나올 때 까지 end 인덱스를 늘리면서 방문처리해나간다.
// 중복된 숫자가 나오면, 시작점부터 최종까지의 개수를 더해주고 처음 숫자의 방문처리를 초기화시켜준다.
public class Main13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        boolean[] visited = new boolean[100001];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        int end = 0;
        for (int i = 0; i < N; i++) {
            while (end < N && !visited[numbers.get(end)]) {
                visited[numbers.get(end)] = true;
                end++;
            }

            answer += end - i;
            visited[numbers.get(i)] = false;
        }

        System.out.println(answer);
    }
}
