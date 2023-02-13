package Programmers.Kakao.Kakao2022;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

// 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// 시간을 저장해두고, 초과요금을 구한다.
class ParkingFee {
    // 총 주차시간
    // 기본시간 이하 - 기본요금
    // 기본시간 초과 - 기본요금 + ((초과시간 올림 / 단위시간) * 단위요금)
    int baseTime;
    int baseFee;
    int unitTime;
    int unitFee;
    // 시간 변환 포맷
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        // 차량 출입기록 저장
        HashMap<String, String> parking = new HashMap<>();

        // 차량별 총 시간
        HashMap<String, Integer> totalTime = new HashMap<>();

        // 기록을 확인해서 IN이면 기록하는 HashMap에 저장, OUT일 경우 요금계산해서 더하기
        for (String s : records) {
            String[] record = s.split(" ");

            String time = record[0];
            String carNumber = record[1];
            String inOut = record[2];

            // IN 이면 Map에 차량번호와 시간 저장
            if(inOut.equals("IN")) {
                parking.put(carNumber, time);
                continue;
            }

            // OUT 이면 총 시간 계산 및 저장 후, 저장된 차량 삭제
            // 차이 시간
            int diffMinute = getDiffMinute(parking.get(carNumber), time);

            // 출차 시에 총 시간 더하고, 주차된 차량 삭제
            totalTime.put(carNumber, totalTime.getOrDefault(carNumber,0) + diffMinute);
            parking.remove(carNumber);
        }


        // 입차기록만 있는 차량
        List<String> parkingKeys = new ArrayList<>(parking.keySet());
        for(String key : parkingKeys) {
            int diffMinute = getDiffMinute(parking.get(key), "23:59");

            // 출차 시에 총 시간 더하고, 주차된 차량 삭제
            totalTime.put(key, totalTime.getOrDefault(key, 0) + diffMinute);
            parking.remove(key);
        }

        // 요금 총액 결과배열
        int[] answer = new int[totalTime.size()];

        // 차량 번호 낮은 순서로 정렬
        List<String> keySet = new ArrayList<>(totalTime.keySet());
        Collections.sort(keySet);

        // 각 차량 별로 총 요금 더하기
        for(int i = 0; i < keySet.size(); i++) {
            int time = totalTime.get(keySet.get(i));
            int fee = baseFee;
            if(baseTime < time) {
                double diff = (double) (time - baseTime) / unitTime;
                fee += (Math.ceil(diff) * unitFee);
            }
            answer[i] = fee;
        }

        return answer;
    }

    // 차이 시간 구하기
    private int getDiffMinute(String beforeTime, String afterTime) {
        LocalTime inTime = LocalTime.parse(beforeTime, format);
        LocalTime outTime = LocalTime.parse(afterTime, format);
        long diffSecond = Duration.between(inTime, outTime).getSeconds();
        return (int) diffSecond / 60;
    }
}
