# [알고리즘] 구간 합 (Cumulative Sum 또는 Prefix Sum)

**구간 합**은 배열의 특정 구간의 합을 효율적으로 계산하기 위한 기법입니다.  
누적 합을 미리 계산해 두고 이를 활용하여 **O(1)**의 시간 복잡도로 구간 합을 계산할 수 있습니다.

---

## 기본 아이디어

1. 누적 합(Prefix Sum)을 배열에 미리 계산합니다.
2. 특정 구간 `[i, j]`의 합은 다음과 같이 구합니다:
    ```text
    구간 합 = prefixSum[j] - prefixSum[i-1]
    ```

---

## 코드 예제

아래는 배열에서 구간 합을 계산하는 기본 코드입니다:

```java
int[] nums = {1, 2, 3, 4, 5};
int[] prefixSum = new int[nums.length + 1];

// 누적 합 계산
for (int i = 1; i <= nums.length; i++) {
    prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
}

// 특정 구간 [1, 3]의 합 구하기
int left = 1, right = 3;
int sum = prefixSum[right] - prefixSum[left - 1];
System.out.println("구간 합: " + sum); // 출력: 9
```

---

### 실행 흐름 (예제: 특정 구간 [1, 3]의 합 구하기)

#### 1. 입력 데이터
- 배열: `{1, 2, 3, 4, 5}`
- 구간: `[1, 3]`

#### 2. 누적 합 배열 계산
- `prefixSum[0] = 0` (초기 값)
- `prefixSum[1] = prefixSum[0] + nums[0] = 1`
- `prefixSum[2] = prefixSum[1] + nums[1] = 3`
- `prefixSum[3] = prefixSum[2] + nums[2] = 6`
- `prefixSum[4] = prefixSum[3] + nums[3] = 10`
- `prefixSum[5] = prefixSum[4] + nums[4] = 15`

#### 3. 특정 구간 `[1, 3]`의 합 계산
- `prefixSum[right] = prefixSum[3] = 6`
- `prefixSum[left-1] = prefixSum[0] = 0`
- 결과: `구간 합 = prefixSum[3] - prefixSum[0] = 6 - 0 = 6`

**최종 정답:** `6`

---

## 활용 예제

1. **부분합 쿼리**
  - 여러 번의 구간 합 계산이 요구되는 문제에서 매우 효율적
2. **2D 배열로 확장**
  - 2차원 구간 합 테이블을 만들어 다양한 문제를 해결 가능

   예: 2차원 배열의 `[r1, c1]` → `[r2, c2]` 구간 계산

---

## 구간 합의 시간 복잡도

- **누적 합 계산**: `O(N)`
  - 초기 계산 시 **한 번의 순회**로 누적 합 배열 작성
- **구간 합 계산**: `O(1)`
  - 이미 계산된 누적 합 배열을 활용해 **즉시 계산**
