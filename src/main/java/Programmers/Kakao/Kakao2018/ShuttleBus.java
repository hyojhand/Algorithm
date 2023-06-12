package Programmers.Kakao.Kakao2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 셔틀버스
// 시간처리를 위해 시를 분으로 변환해서 사용한다.
// 우선순위 큐에 크루의 도착 시간을 저장한다.
// 시작 시간부터 탑승가능한 인원만큼 우선순위큐에서 뺴내고, 마지막 탑승셔틀일 때 조건을 추가한다.
// 마지막 셔틀이 꽉 찼다면 마지막에 도착한 인원보다 1분 빠르게 도착하고, 자리가 있따면 출발시간에 맞춰 도착하도록한다.
class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> times = new PriorityQueue<>();

        for (String time : timetable) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3));
            times.add(hour * 60 + minute);
        }

        // 시작시간 9:00 = 540분
        int departTime = 540;
        int resultTime = 0;

        // 셔틀 운행횟수
        for (int i = 0; i < n; i++) {

            // 셔틀 탑승인원 마지막 시간
            int maxTime = 0;
            // 셔틀버스에 탄 인원
            int count = 0;

            while (!times.isEmpty()) {
                // 더이상 빨리온 인원이 없거나 모두 탔다면 break
                if (times.peek() > departTime || count == m) {
                    break;
                }

                count++;
                maxTime = Math.max(maxTime, times.poll());
            }

            // 마지막 셔틀버스인 경우
            if (i == n - 1) {

                // 마지막 셔틀에 모두 탔다면 가장 마지막 도착시간 -1분
                if (count == m) {
                    resultTime = maxTime - 1;
                }
                // 덜 탓다면 마지막 출발시간에 바로 탑승할 수 있다.
                else if (count < m) {
                    resultTime = departTime;
                }
            }

            // 다음 출발시간
            departTime += t;
        }

        String hour = String.format("%02d", resultTime / 60);
        String minute = String.format("%02d", resultTime % 60);
        return hour + ":" + minute;
    }
}
