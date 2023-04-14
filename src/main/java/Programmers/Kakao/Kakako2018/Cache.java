package Programmers.Kakao.Kakako2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시
// ArrayList로 캐시를 구현한다.
// cacheSize는 0이 될 수 있으므로, 0이라면 배열의 개수 * 5(캐시미스 시간)을 곱해서 반환한다.
// 리스트에 포함된 단어라면 캐시히트의 시간만큼 더하고, 해당 단어를 최신화 하기 위해 삭제후 다시 삽입한다.
// 리스트에 포함되지 않았다면, 캐시 미스의 시간만큼 더한다.
// 캐시가 꽉 차지 않았으면 캐시에 바로 더하고, 꽉 찼다면 가장 첫번째 요소(마지막 검색 요소)를 삭제하고 더한다.
class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 캐시 사이즈가 0이라면 도시 수만큼 5의 실행시간 반환
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        // 캐시
        List<String> cache = new ArrayList<>();

        for (String city : cities) {
            // 대소문자 통일
            city = city.toUpperCase();

            // cache hit
            if (cache.contains(city)) {
                answer += 1;
                // 캐시 갱신
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;

                // 캐시가 꽉 찼으면 마지막 도시 삭제
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }

                // 최근 검색 도시 캐시에 넣기
                cache.add(city);
            }
        }

        return answer;
    }
}