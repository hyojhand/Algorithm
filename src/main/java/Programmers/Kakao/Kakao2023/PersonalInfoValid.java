package Programmers.Kakao.Kakao2023;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

// 2023 KAKAO BLIND RECRUITMENT - 개인정보 수집 유효기간
public class PersonalInfoValid {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();

        // DateTimeFormatter
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        // LocalDate 타입의 today
        LocalDate todayDate = LocalDate.parse(today, format);

        // 약관을 저장하는 HashMap store
        HashMap<String, Integer> store = new HashMap<>();
        for (String term : terms) {
            String[] value = term.split(" ");
            store.put(value[0], Integer.parseInt(value[1]));
        }

        // 약관 기한 비교
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String dateValue = privacy[0];
            String type = privacy[1];

            // LocalDate 타입의 privacy
            LocalDate date = LocalDate.parse(dateValue, format);
            date = date.plusMonths(store.get(type));

            // 약관을 더했을때 이전이거나 당일이라면 이미 만료된 개인정보
            if (date.isBefore(todayDate) || date.isEqual(todayDate)) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
