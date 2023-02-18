package Programmers.Kakao.Kakao2021;

import java.util.*;
// 2021 KAKAO BLIND RECRUITMENT - 순위 검색
// HashMap에 key들을 연결하여 저장하고, value를 score 점수 리스트로 저장해서 사용한다. HashMap<String, List<Integer>
// key 경우의 수를 모두 구해서 score를 저장해 놓는다. ("-") 포함
// value값이 정렬된 HashMap에서 조건(query)에 해당하는 값들을 이분탐색하여 충족하는 갯수를 구한다.
class RankSearch {

    // 조건들을  score의 리스트를 value로 가지는 HashMap
    HashMap<String, List<Integer>> scoreStore = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 각 정보를 담은 Info 클래스 리스트에 담기
        for (int i = 0; i < info.length; i++) {
            String[] splitInfo = info[i].split(" ");

            dfs("", 0, splitInfo);
            // infos.add(new Info(language, group, career, food, score));
        }

        // score 오름차순으로 정렬
        for (String key : scoreStore.keySet()) {
            Collections.sort(scoreStore.get(key));
        }

        // query에 맞게 인원수 확인
        for (int i = 0; i < query.length; i++) {
            answer[i] = findMember(query[i]);
        }

        return answer;
    }

    // key로 가능한 "-"포함하여 경우의 수를 HashMap에 score로 저장해놓는다.
    private void dfs(String key, int dept, String[] info) {
        if (dept == 4) {
            // 처음 값이라면 list 생성
            if (!scoreStore.containsKey(key)) {
                scoreStore.put(key, new ArrayList<>());
            }

            // scoreStore.put(key, scoreStore.get(key).add(key));
            // HashMap List에 score를 저장한다
            scoreStore.get(key).add(Integer.parseInt(info[dept]));
            return;
        }

        // "-"인 경우도 포함
        dfs(key + "-", dept + 1, info);
        dfs(key + info[dept], dept + 1, info);
    }

    // 인원수를 확인
    private int findMember(String query) {
        String[] split = query.split(" and | ");
        String key = split[0] + split[1] + split[2] + split[3];
        int score = Integer.parseInt(split[4]);

        // key가 없다면 0 리턴
        if (!scoreStore.containsKey(key)) {
            return 0;
        }

        List<Integer> scores = scoreStore.get(key);
        return scores.size() - binarySearch(scores, score);
    }

    // 이분탐색으로 count
    private int binarySearch(List<Integer> scores, int score) {
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

}
