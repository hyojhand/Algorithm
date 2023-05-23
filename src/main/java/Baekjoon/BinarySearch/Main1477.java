package Baekjoon.BinarySearch;

import java.io.*;
import java.util.*;

// G4 휴게소 세우기
// 각 지점을 입력받아 리스트에 저장하고, 처음과 끝인 0과 L도 저장하여 정렬한다.
// 이분탐색의 mid가 간격이 될 때, 총 몇개를 설치할 수 있는지 확인한다.
// 리스트에서 앞의 숫자와 차이를 간격(mid)로 나누면 몇개 설치할 수 있는지 알 수 있다.
// M보다 크다면, 간격의 값을 줄이기 위해 start를 mid + 1로 변경하고,
// M보다 작거나같으면, 간격을 늘리기 위해 end를 mid - 1로 변경한다.
// start가 end를 넘어갈 때 반복문을 종료하며 최종값을 얻을 수 있다.
public class Main1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 휴게소 지점 저장
        List<Integer> rests = new ArrayList<>();
        rests.add(0);
        rests.add(L);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rests.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Collections.sort(rests);

        // start가 0이고, end가 1이되면 간격이 0이 되면서 0으로 나누는 경우가 생기기 때문에 1로 설정
        int start = 1;
        int end = L;
        while (start <= end) {
            int mid = (start + end) / 2;

            // mid 간격으로 총 몇개를 설치할 수 있는지 개수
            int count = getMakeCount(rests, mid);

            if (M < count) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    private static int getMakeCount(List<Integer> rests, int mid) {
        int count = 0;
        for (int i = 1; i < rests.size(); i++) {
            count += (rests.get(i) - rests.get(i - 1) - 1) / mid;
        }
        return count;
    }
}

