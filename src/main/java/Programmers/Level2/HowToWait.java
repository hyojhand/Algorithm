package Programmers.Level2;

import java.util.*;

// Level 2 - 줄 서는 방법
// 팩토리얼을 활용해, 팩토리얼 만큼 나눈 간격으로 가장 앞 숫자의 위치가 변경된다.
public class HowToWait {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // 숫자 저장
        List<Integer> numbers = new ArrayList<>();
        // 팩토리얼 저장
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            numbers.add(i);
        }

        // 최초 k는 시작이 1이므로, k - 1로 갱신해서 리스트의 인덱스와 맞춰준다.
        k--;

        int index = 0;
        while (index < n) {

            // 팩토리얼을 n에서 하나씩 낮춰간다
            factorial = factorial / (n - index);

            // k를 팩토리얼로 나눴을 때의 위치한 숫자가 오게된다.
            long order = k / factorial;
            // 해당 위치의 숫자를 넣고, 삭제
            answer[index++] = numbers.get((int) order);
            numbers.remove((int) order);

            // k를 나머지 연산하여 갱신
            k = k % factorial;
        }

        return answer;
    }
}
