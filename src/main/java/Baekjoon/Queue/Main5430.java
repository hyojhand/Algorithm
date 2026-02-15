package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
// Deque 사용
// R 커맨드시 flag 처리하여 pollFirst, pollLast 활용
public class Main5430 {
    static Deque<String> deque;
    static boolean isError;
    static boolean isFirst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String command = br.readLine();

            int cnt = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.replace("[", "");
            input = input.replace("]", "");
            String[] split = input.split(",");

            deque = new ArrayDeque<>();
            for(int i = 0; i < cnt; i++) {
                deque.offerLast(split[i]);
            }

            command = command.replace("RR", "");

            isError = false;
            isFirst = true; // 시작은 왼쪽
            for(int i = 0; i < command.length(); i++) {

                if(command.charAt(i) == 'R') {
                    roll();
                }

                if(command.charAt(i) == 'D') {
                    delete();
                }

                if(isError) {
                    result.append("error");
                    break;
                }
            }

            if(!isError) {
                result.append("[");

                int size = deque.size();
                for(int i = 0; i < size; i++) {

                    if(isFirst) result.append(deque.pollFirst());
                    else result.append(deque.pollLast());


                    if(i != size - 1) result.append(",");
                }
                result.append("]");
            }

            if(T != 0) result.append('\n');
        }

        System.out.println(result);
    }

    static void roll() {
        if(isFirst) {
            isFirst = false;
            return;
        }

        isFirst = true;
    }

    static void delete() {
        if(deque.size() < 1) {
            isError = true;
            return;
        }

        if(isFirst) deque.pollFirst();
        else deque.pollLast();
    }
}
