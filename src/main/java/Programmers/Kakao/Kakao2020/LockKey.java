package Programmers.Kakao.Kakao2020;

// 2020 KAKAO BLIND RECRUITMENT - 자물쇠와 열쇠
// 먼저, lock 배열을 중앙으로 key 배열 크기의 -1만큼 상하좌우로 확장시킨다.
// 확장된 lock 배열을 key 배열이 넘어가지 않는만큼 (확장 배열사이즈 - key 사이즈) 키를 회전시키며 탐색한다.
// 이때, key 배열은 4번회전시키며 왼쪽 상단부터 모든 경우의 수를 확인한다.
// 확장 배열의 값과 key 배열의 값을 더하여, 확장배열의 중앙에 위치한 원래 배열의 값들이 모두 1인 경우 true 결과를 반환해준다.
class LockKey {
    int keySize;
    int lockSize;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        lockSize = lock.length;
        keySize = key.length;
        // 새 배열의 크기 = lock 배열크기 + (key 배열크기 -1) * 2
        int N = lockSize + (keySize - 1) * 2;
        // 확장된 lock 배열
        int[][] expandLock = new int[N][N];

        // lock 배열 확장
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                expandLock[i + keySize - 1][j + keySize - 1] = lock[i][j];
            }
        }

        // 확장된 lock 배열을 key 배열이 넘어가지 않는만큼 모두 탐색
        for (int i = 0; i <= N - keySize; i++) {
            for (int j = 0; j <= N - keySize; j++) {

                // key 배열을 4번 회전하여 모두 탐색
                for (int k = 0; k < 4; k++) {

                    // key배열 회전
                    key = rotateKey(key);

                    // 맞는 키라면 return
                    if (checkKey(i, j, key, expandLock)) {
                        return true;
                    }

                }
            }
        }

        return answer;
    }

    private boolean checkKey(int x, int y, int[][] key, int[][] expandLock) {
        // key 배열의 값을 추가한 복사배열
        int[][] keyValue = new int[expandLock.length][expandLock.length];
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                keyValue[x + i][y + j] = key[i][j];
            }
        }

        // 확장 배열의 시작점
        int start = keySize - 1;
        // expandLock을 탐색하는데, key 배열의 값을 가진 keyValue를 더해준다.
        for (int i = start; i < start + lockSize; i++) {
            for (int j = start; j < start + lockSize; j++) {

                int number = expandLock[i][j] + keyValue[i][j];

                // 1이아니라면(0 or 2), 맞지않으므로 false 리턴
                if (number != 1) {
                    return false;
                }

            }
        }

        return true;
    }

    // key 배열 회전
    private int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[keySize][keySize];
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                newKey[i][j] = key[keySize - j - 1][i];
            }
        }

        return newKey;
    }
}
