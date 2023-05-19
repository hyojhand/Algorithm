package HackerRank;

import java.util.*;

// 각 리스트의 크기가 1000으로 2중 for문으로 완전 탐색으로 풀이할 수 있다.
// 좌측상단의 0,0을 시작지점으로 하여 G의 전체 크기에서 P의 크기만큼을 뺀 지점까지 탐색한다.
// G의 (x,y) 좌표에서 P의 (0,0)과 같은 값이라면, 해당 행을 P의 크기만큼 substring하여 같은지 비교한다.
// 같은 행의 수만큼 카운트를 올려주고, P의 행 크기와 같다면 YES를 반환한다.
// 모든 좌표를 탐색해도 만족하지 못하면, NO를 반환해준다.
class GridSearch {
    public static String gridSearch(List<String> G, List<String> P) {

        // G 리스트의 행렬 크기
        int gRow = G.size();
        int gCol = G.get(0).length();

        // P 리스트의 행렬 크기
        int pRow = P.size();
        int pCol = P.get(0).length();

        // 시작지점이 G에서 P의 크기만큼 뺀 지점까지 탐색
        for (int i = 0; i <= gRow - pRow; i++) {
            for (int j = 0; j <= gCol - pCol; j++) {

                // 시작이 같은 단어라면 확인
                if (G.get(i).charAt(j) == P.get(0).charAt(0)) {

                    // 같은 행 개수
                    int count = 0;
                    // P 리스트 만큼 비교
                    for (int k = 0; k < pRow; k++) {

                        // G리스트에서 P의 길이만큼 substring
                        String valueG = G.get(i + k).substring(j, j + pCol);
                        String valueP = P.get(k);

                        // 둘이 다르다면 break
                        if (!valueG.equals(valueP)) {
                            break;
                        }

                        count++;
                    }

                    // 같은 개수가 P의 행 개수와 같다면 YES 반환
                    if (count == pRow) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }
}
