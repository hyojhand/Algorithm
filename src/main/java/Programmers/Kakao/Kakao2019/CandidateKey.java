package Programmers.Kakao.Kakao2019;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT - 후보키
// row의 길이가 20이하이므로, dfs로 모든 후보키의 후보를 탐색한다.
// 해당 인덱스의 속성(Attribute)을 포함하지 않는 순서부터 포함하는 순서로 boolean 배열(check 배열)에 인덱스를 체크하며 모든 속성을 탐색한다.
// 유일성, 최소성을 체크한다.
// 유일성은 포함하는 인덱스의 각 속성을 row마다 이어붙여 모든 개수와 같은지를 통해 유일성을 판단한다.
// 최소성은 conatinsAll을 사용해 이미 후보키 목록의 모든 요소를 포함하고 있는지를 통해 최소성을 판단한다.
// (주의사항 - dfs를 할 때, 포함하지 않는 순서부터 탐색해야 한다. 포함하는 순서부터 역으로 내려오면 모든 conatinsAll을 사용할 수 없다.)
// 최종 후보키의 목록 개수를 반환한다.
class CandidateKey {
    int tupleSize, attributeSize;
    boolean[] check;
    List<ArrayList<Integer>> answer = new ArrayList<>();

    public int solution(String[][] relation) {
        tupleSize = relation.length;
        attributeSize = relation[0].length;

        check = new boolean[attributeSize];

        for (int i = 0; i < attributeSize; i++) {
            dfs(0, relation);
        }

        return answer.size();
    }

    private void dfs(int index, String[][] relation) {
        if (index == attributeSize) {

            // 체크된 인덱스를 가지는 리스트
            ArrayList<Integer> keyIndexes = new ArrayList<>();
            for (int i = 0; i < attributeSize; i++) {
                if (check[i]) {
                    keyIndexes.add(i);
                }
            }

            // 유일성 체크
            if (!unique(keyIndexes, relation)) {
                return;
            }

            // 최소성 체크
            for (ArrayList<Integer> indexList : answer) {
                if (keyIndexes.containsAll(indexList)) {
                    return;
                }
            }

            // 모두 만족하면 후보키 추가
            answer.add(keyIndexes);
            return;
        }

        for (int i = index; i < attributeSize; i++) {
            // 포함하지 않는 순서부터 dfs
            dfs(i + 1, relation);
            check[i] = true;
            // 해당 속성을 포함하며 dfs
            dfs(i + 1, relation);
            check[i] = false;
        }

    }

    // 유일성 판단
    private boolean unique(List<Integer> keyIndexes, String[][] relation) {
        HashSet<String> keys = new HashSet<>();

        for (int i = 0; i < tupleSize; i++) {
            String key = "";

            // 인덱스에 해당하는 값을 합친 키
            for (int index : keyIndexes) {
                key += relation[i][index];
            }

            // 이미 포함된 키라면, 유일성 위배
            if (keys.contains(key)) {
                return false;
            } else {
                keys.add(key);
            }
        }

        // 중복되는 키가 있다면 유일성 위배
        if (keys.size() != tupleSize) {
            return false;
        }

        return true;
    }
}
