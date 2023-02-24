package Programmers.Kakao.Kakao2021;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
// 주문 가능한 메뉴의 조합과 빈도수를 저장해두고, 가장 많이 만들어진 메뉴를 각 길이만큼 뽑아내서 정렬한다.
class MenuRenewal {

    HashMap<String, Integer> result = new HashMap<>();
    List<String> resultList = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        // orders 내부 String 정렬
        for (int i = 0; i < orders.length; i++) {
            orders[i] = Stream.of(orders[i].split(""))
                    .sorted()
                    .collect(Collectors.joining());
        }

        for (int count : course) {
            for (String order : orders) {
                // order를 수만큼 메뉴로 만들어서 HashMap에 저장
                dfs("", order, count);
            }

            // 비어있지 않다면
            if (!result.isEmpty()) {
                // 최대 포함 수
                int max = Collections.max(result.values());

                // 2번 이상일 때만
                if (max > 1) {
                    for (String key : result.keySet()) {
                        // 메뉴 만든 수가 최대값과 같다면 결과 리스트에 넣는다.
                        if (result.get(key) == max) {
                            resultList.add(key);
                        }
                    }
                }
                result.clear();
            }
        }

        // 결과 오름차순 정렬
        Collections.sort(resultList);

        String[] answer = new String[resultList.size()];

        int idx = 0;
        for (String value : resultList) {
            answer[idx++] = value;
        }
        return answer;
    }

    // order에서 count가 0이 될 때까지 메뉴 조합 구하기
    private void dfs(String menu, String order, int count) {
        // 정해진 수만큼 메뉴가 정해졌으면 HashMap 저장
        if (count == 0) {
            result.put(menu, result.getOrDefault(menu, 0) + 1);
            return;
        }

        // 메뉴 선택 후 뒤의 문자열부터 dfs
        for (int i = 0; i < order.length(); i++) {
            dfs(menu + order.charAt(i), order.substring(i + 1), count - 1);
        }
    }
}
