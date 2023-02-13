package Programmers.Kakao.Kakao2022;

import java.util.*;

// 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// 입차(IN)시에 -로, 출차(OUT)시에 +로 계산해서 시간을 바로 구한다
class ParkingFeeVer2 {
    // 총 주차시간
    // 기본시간 이하 - 기본요금
    // 기본시간 초과 - 기본요금 + ((초과시간 올림 / 단위시간) * 단위요금)
    int baseTime;
    int baseFee;
    int unitTime;
    int unitFee;

    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        // 출입시간 저장 TreeMap (번호표 순으로 오름차순 정렬)
        TreeMap<String, Integer> store = new TreeMap<>();

        // 기록을 확인
        for (String value : records) {
            String[] record = value.split(" ");

            // 입차(IN)이면 -1, 출차(OUT)이면 +1로 분(MINUTE)을 계산한다.
            int time = record[2].equals("IN") ? -1 : 1;
            time *= getTimeToMinute(record[0]);
            store.put(record[1], store.getOrDefault(record[1], 0) + time);
        }

        // 기록이 있는 만큼 결과 배열
        int[] answer = new int[store.size()];
        int idx = 0;

        // time을 확인
        for (int time : store.values()) {
            // 시간이 1보다 작다면 (00:00 부터 시작이후 출차 기록 없는 경우)
            if (time < 1) {
                // 23:59 만큼의 출차시간을 더해준다
                time += 1439;
            }

            // 기본 시간을 뺀다
            time -= baseTime;
            int cost = baseFee;

            // 기본시간보다 더 많을 경우
            if (time > 0) {
                // 초과된 시간을 올림해서 단위시간만큼 더한다
                cost += (Math.ceil((double) time / unitTime) * unitFee);
            }
            answer[idx++] = cost;
        }

        return answer;
    }

    // "HH:mm"형태의 time을 분(Minute)으로 변환해서 반환
    private int getTimeToMinute(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}