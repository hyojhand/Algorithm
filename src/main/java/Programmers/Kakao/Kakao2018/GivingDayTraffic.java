package Programmers.Kakao.Kakao2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 추석 트래픽
// 날짜를 제외한 시간, 처리 시간을 각자 파싱해서 밀리세컨 단위로 맞춰준다.
// 이후, 해당 트래픽의 시작 시간과 종료 시간을 가지는 리스트에 저장해놓는다.
// 각 트래픽을 선택하여, 해당 트래픽의 종료 시간을 시작으로 1초(1000ms)를 더했을 때의 시간이
// 다른 트래픽들의 시작 시간보다 크다면 1초가 무조건 겹치는 트래픽이기 때문에 카운트해준다.
// 한 트래픽을 선택했을 때, 겹치는 카운트가 최대인 개수를 최종 답으로 반환한다.
public class GivingDayTraffic {
    public int solution(String[] lines) {
        int answer = 0;

        List<Traffic> traffics = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            long end = getTime(split[1]);
            long spent = (long) (Double.parseDouble(split[2].replaceAll("s", "")) * 1000);
            long start = end - spent + 1;

            traffics.add(new Traffic(start, end));
        }

        for (int i = 0; i < traffics.size(); i++) {
            int count = 1;

            for (int j = i + 1; j < traffics.size(); j++) {
                if (traffics.get(i).end + 1000 > traffics.get(j).start) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private long getTime(String input) {
        String[] arr = input.split(":");

        long hour = Long.parseLong(arr[0]) * 60 * 60 * 1000;
        long minute = Long.parseLong(arr[1]) * 60 * 1000;
        long second = (long) (Double.parseDouble(arr[2]) * 1000);
        return hour + minute + second;
    }

    private class Traffic {
        long start, end;

        public Traffic(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
