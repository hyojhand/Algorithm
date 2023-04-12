package Baekjoon.Greedy;

import java.io.*;
import java.util.*;
// G5 최소 회의실 개수
// 시작시간 순으로 정렬하고, 회의실 종료시간을 우선순위 큐로 가진다.
// 우선순위 큐의 종료시간과 들어올 회의 시작시간 비교
// 1. 시작시간이 종료시간과 같거나 종료이후 사용가능하면 해당 시간의 종료시간을 갱신한다 (poll -> offer)
// 2. 가장 짧은 종료시간인데 빨리 시작해야한다면 새로운 회의실을 사용해야한다 (offer)
public class Main19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // 시작시간 순 정렬
        Collections.sort(meetings);

        // 현재 진행되는 미팅 우선순위 큐
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (Meeting meeting : meetings) {

            if (endTimes.isEmpty()) {
                endTimes.offer(meeting.end);
                continue;
            }

            // 시작시간이 종료시간과 같거나 종료이후 사용가능하면 새로 갱신
            if (meeting.start >= endTimes.peek()) {
                endTimes.poll();
            }

            endTimes.offer(meeting.end);
        }

        System.out.println(endTimes.size());
    }


    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.start == m.start) {
                return this.end - m.end;
            }

            return this.start - m.start;
        }
    }
}
