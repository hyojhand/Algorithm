package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 메모리 초과 해결 방법
// Deque 구현 클래스 LinkedList vs ArrayDeque
public class Main2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Ballon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.offerLast(new Ballon(num, i + 1));
        }

        int target = 0;
        int count = 0;
        int direct = 1; // 1은 양수, -1은 음수
        String answer = "";
        StringBuilder builder = new StringBuilder();
        while(deque.size() > 0) {

            Ballon poll;
            if(direct == 1) {
                poll = deque.pollFirst();
            } else {
                poll = deque.pollLast();
            }

            if(target == count) {
                builder.append(poll.index).append(" ");
//                answer += poll.index + " ";
                target = poll.num;
                if(target < 0) {
                    direct = -1;
                    target = target * -1;
                } else {
                    direct = 1;
                }

                count = 1;
                continue;
            }

            if(direct == 1) {
                deque.offerLast(poll);
            } else {
                deque.offerFirst(poll);
            }
            count++;
        }

        System.out.println(builder);
    }

    static class Ballon {
        int num, index;
        public Ballon(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}

