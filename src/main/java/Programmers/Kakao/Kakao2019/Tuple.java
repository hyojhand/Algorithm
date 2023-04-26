package Programmers.Kakao.Kakao2019;

import java.util.*;

// 2019 카카오 개발자 겨울 인턴십 - 튜플
// 방법 1
// 문자열 파싱이후 길이가 짧은 순서로 정렬하고, 튜플에 없는 원소가 나오면 추가하는 방식으로 튜플을 만들어 나간다.
class Tuple {
    public int[] solution(String s) {

        String[] values = s.split("}");
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].substring(2);
        }

        // 길이 순으로 정렬
        Arrays.sort(values, (o1, o2) -> o1.length() - o2.length());

        List<Integer> answer = new ArrayList<>();

        for (String value : values) {
            String[] numbers = value.split(",");

            for (String number : numbers) {
                int num = Integer.parseInt(number);

                // 포함하지 않는 원소는 튜플에 추가하고 break
                if (!answer.contains(num)) {
                    answer.add(num);
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }


    // 방법 2
    // HashMap에 각 숫자를 모두 넣으며 빈도를 카운트한다.
    // 가장 많이 카운트 된 순서(value)로 정렬하고 배열에 넣으면 튜플이 완성된다.
//    HashMap<String, Integer> memory = new HashMap<>();
//
//    public int[] solution(String s) {
//
//        String[] values = s.split("}");
//        for (int i = 0; i < values.length; i++) {
//            values[i] = values[i].substring(2);
//            // 출현빈도 저장
//            saveFrequency(values[i]);
//        }
//
//        // value 순서로 key 정렬
//        List<String> keys = new ArrayList<>(memory.keySet());
//        Collections.sort(keys, (o1, o2) -> memory.get(o2) - memory.get(o1));
//
//        // 순서대로 결과 튜플에 넣기
//        List<Integer> answer = new ArrayList<>();
//        for (String key : keys) {
//            answer.add(Integer.parseInt(key));
//        }
//
//        return answer.stream().mapToInt(i -> i).toArray();
//    }
//
//    private void saveFrequency(String value) {
//        String[] numbers = value.split(",");
//
//        for (String number : numbers) {
//            memory.put(number, memory.getOrDefault(number, 0) + 1);
//        }
//    }
}
