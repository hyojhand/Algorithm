package Programmers.Level2;

import java.util.*;

// Level 2 - 뒤에 있는 큰 수 찾기
// 최대값들을 담아놓는 용도로 스택을 사용한다.
// 끝부터 스택에 최대값을 담는다.
// 스택에 값이 있다면 최대값인지 확인하고, 최대값이라면 저장이후 break, 최대값이 아니면 더 큰 최대값이 나올 때 까지 pop
// 아직 스택이 비어있다면 최대값을 찾지 못하고 모두 뺀 것이므로, -1로 저장
// 현재 값을 스택에 저장하고 다음 반복문 실행
class BackNumber {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];

        Stack<Integer> stack = new Stack<>();
        // 끝부터 스택에 넣기
        for (int i = size - 1; i >= 0; i--) {
            // 스택에 값이 있다면
            while (!stack.isEmpty()) {
                // 가장 가까운 값이 더 크면, 최대값 저장이후 break
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    // 큰 값이 아니면 스택에서 pop
                    stack.pop();
                }
            }

            // 만약 스택이 비었다면 아직 최대값을 찾지 못했으니 -1
            if (stack.isEmpty()) {
                answer[i] = -1;
            }

            // 스택에 지금 값 넣기
            stack.push(numbers[i]);
        }

        return answer;
    }
}
