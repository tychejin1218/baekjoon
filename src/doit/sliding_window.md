# [알고리즘] 슬라이딩 윈도우 (Sliding Window)

**슬라이딩 윈도우**는 배열 위를 고정된 크기 또는 가변 크기의 창(Window)을 움직이며 문제를 해결하는 기법입니다.

---

## 기본 아이디어

1. 크기 `k`의 윈도우를 유지하며 배열에서 데이터를 처리합니다.
2. 윈도우를 한 칸씩 이동시키며 빠지는 값을 제거하고 새로 추가되는 값을 더합니다.

---

## 코드 예제

아래 코드는 크기가 `3`인 윈도우에서 최대 합을 찾는 코드입니다:

```java
int[] nums = {2, 1, 5, 1, 3, 2};
int k = 3, maxSum = 0, windowSum = 0;

// 첫 번째 윈도우 계산
for (int i = 0; i < k; i++) {
    windowSum += nums[i];
}
maxSum = windowSum;

// 윈도우 슬라이딩
for (int i = k; i < nums.length; i++) {
    windowSum += nums[i] - nums[i - k];
    maxSum = Math.max(maxSum, windowSum);
}

System.out.println("최대 윈도우 합: " + maxSum); // 출력: 9
```

---

### 실행 흐름 (예제: 최대 합 찾기)

#### 1. 입력 데이터
- 배열: `{2, 1, 5, 1, 3, 2}`
- 윈도우 크기: `k = 3`

#### 2. 첫 번째 윈도우
- 윈도우 범위: `nums[0]` → `nums[2]` (`{2, 1, 5}`)
- 계산: `windowSum = 2 + 1 + 5 = 8`
- `maxSum = windowSum = 8`

#### 3. 윈도우 슬라이딩 (1칸씩 이동)
- **두 번째 윈도우**:
    - 범위: `nums[1]` → `nums[3]` (`{1, 5, 1}`)
    - 계산: `windowSum = windowSum + nums[3] - nums[0] = 8 + 1 - 2 = 7`
    - `maxSum = Math.max(maxSum, windowSum) = Math.max(8, 7) = 8`

- **세 번째 윈도우**:
    - 범위: `nums[2]` → `nums[4]` (`{5, 1, 3}`)
    - 계산: `windowSum = windowSum + nums[4] - nums[1] = 7 + 3 - 1 = 9`
    - `maxSum = Math.max(maxSum, windowSum) = Math.max(8, 9) = 9`

- **네 번째 윈도우**:
    - 범위: `nums[3]` → `nums[5]` (`{1, 3, 2}`)
    - 계산: `windowSum = windowSum + nums[5] - nums[2] = 9 + 2 - 5 = 6`
    - `maxSum = Math.max(maxSum, windowSum) = Math.max(9, 6) = 9`

#### 4. 출력 결과
- 최대 윈도우 합: `9`

---

## 활용 예제

1. **고정 크기의 최대/최소값 탐색**
    - 예: 배열에서 크기 `k`의 최댓값 구하기
2. **문자열에서 고정된 길이의 패턴 검색**
    - 예: 고정된 길이의 부분 문자열에서 특정 조건 만족 패턴 찾기
3. **변형된 문제 풀이**
    - 예: 가변 크기의 윈도우를 활용한 최소합, 최대길이 서브배열 탐색

---

## 시간 복잡도

- **초기 윈도우 계산**: `O(k)`
- **윈도우 슬라이딩**: `O(N - k)` (한 번의 순회를 통해 모든 윈도우를 계산)
- **총 시간 복잡도**: `O(N)`
    - 배열의 길이가 `N`일 때 한 번만 순회하므로 효율적
