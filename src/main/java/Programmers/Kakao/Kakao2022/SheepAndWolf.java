package Programmers.Kakao.Kakao2022;

import java.util.*;

// 2022 KAKAO BLIND RECRUITMENT - 양과 늑대
// 모든 경우의 수를 확인하며 최대 양의 개수를 구한다.
// 해당 위치에서 이동할 수 있는 지점을 리스트로 관리하며, dfs로 모두 탐색한다.
// 이때, 양과 늑대의 개수를 갱신하고 조건에 맞지않다면 return 해준다.
public class SheepAndWolf {
    int answer = 0;
    List<Integer>[] edgeList;
    int[] infos;

    public int solution(int[] info, int[][] edges) {
        infos = info;

        edgeList = new List[info.length];
        for (int i = 0; i < edgeList.length; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
        }

        List<Integer> nodes = new ArrayList<>();
        nodes.add(0);
        dfs(0, 0, 0, nodes);

        return answer;
    }

    // 현재 위치, 양의 개수, 늑대의 개수, 이동가능한 노드 리스트
    private void dfs(int now, int sheepCount, int wolfCount, List<Integer> nodes) {
        // 양,늑대의 수 갱신
        if (infos[now] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }

        // 늑대의 수가 이상이면 return
        if (sheepCount <= wolfCount) {
            return;
        }

        // 최대값 갱신
        answer = Math.max(answer, sheepCount);


        List<Integer> list = new ArrayList<>();
        for (Integer num : nodes) {
            list.add(num);
        }
        list.remove(Integer.valueOf(now));

        if (!edgeList[now].isEmpty()) {
            for (Integer num : edgeList[now]) {
                list.add(num);
            }
        }

        for (Integer next : list) {
            dfs(next, sheepCount, wolfCount, list);
        }
    }
}
