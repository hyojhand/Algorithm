package Programmers.Kakao.Kakao2019;

import java.util.*;

// 2019 카카오 개발자 겨울 인턴십 - 불량 사용자
// 8 이하의 user_id로 dfs 하여 banId와 일치하는 문자의 개수 구하기
public class BanUser {

    String[] userIds;
    String[] bannedIds;
    // 중복되는 문자열을 제외하기 위해 2중 HashSet 사용
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        dfs(new HashSet<>(), 0);

        return result.size();
    }

    private void dfs(HashSet<String> memory, int dept) {
        // 끝까지 탐색했으면 결과 Set에 추가
        if (dept == bannedIds.length) {
            result.add(memory);
            return;
        }

        for (String userId : userIds) {
            // 이미 포함한 아이디는 제외
            if (memory.contains(userId)) {
                continue;
            }

            // ban id 패턴과 일치하면 추가한 set을 dfs
            if (isBanned(userId, bannedIds[dept])) {
                memory.add(userId);
                dfs(new HashSet<>(memory), dept + 1);
                memory.remove(userId);
            }
        }
    }

    private boolean isBanned(String userId, String bannedId) {
        // 길이부터 다르면 false
        if (bannedId.length() != userId.length()) {
            return false;
        }

        // *을 제외하고 일치하지 않으면 false
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
