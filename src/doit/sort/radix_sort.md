# [알고리즘] 기수 정렬 (Radix Sort)

**기수 정렬**은 숫자의 자릿수를 이용한 정렬 알고리즘입니다.  
가장 낮은 자릿수부터 시작해 점차 높은 자릿수를 기준으로 정렬합니다(LSB 방식: Least Significant Bit First).  
자릿수마다 **계수 정렬(Counting Sort)**을 활용하며, 안정적이고 효율적인 정렬을 보장합니다.

---

## 시간 복잡도
- **최선**: `O(Nk)`
- **평균**: `O(Nk)`
- **최악**: `O(Nk)`  
  여기서 `N`은 배열 길이, `k`는 숫자의 최대 자릿수.

---

## 특징
- **숫자 데이터에 특화**된 정렬 알고리즘.
- **안정 정렬 (Stable Sort)**: 동일한 값을 가진 데이터 간의 상대적 순서를 유지.
- **제자리 정렬 아님**: 추가 메모리를 사용합니다.

---

## 실행 흐름 (단계별 설명)

### 정렬 대상 배열: `[170, 45, 75, 90, 802, 24, 2, 66]`

#### 1. 주요 변수
- **최대값 (`max`)**: 배열의 최대값은 802로, 자릿수(`k`)를 3(백의 자리)로 계산.
- **자릿수별 정렬**:
    - 1의 자리, 10의 자리, 100의 자리 순으로 정렬.

---

#### 2. 자릿수별 정렬 과정

##### 첫 번째 반복: **1의 자리 정렬**
- **1의 자리 값 추출**: `[0, 5, 5, 0, 2, 4, 2, 6]`
- **계수 정렬 후 결과**: `[170, 90, 802, 2, 24, 45, 75, 66]`

---

##### 두 번째 반복: **10의 자리 정렬**
- **10의 자리 값 추출**: `[7, 9, 0, 0, 2, 4, 7, 6]`
- **계수 정렬 후 결과**: `[802, 2, 24, 45, 66, 170, 75, 90]`

---

##### 세 번째 반복: **100의 자리 정렬**
- **100의 자리 값 추출**: `[8, 0, 0, 0, 0, 1, 0, 0]`
- **계수 정렬 후 결과**: `[2, 24, 45, 66, 75, 90, 170, 802]`

---

### 정렬 결과
- **정렬 전 배열**:  `[170 45 75 90 802 24 2 66]`
- **정렬 후 배열**:  `[2 24 45 66 75 90 170 802]`
 
---

## 코드 예제

```java
import java.util.ArrayList;
import java.util.List;

public class RadixSort {
  // Main Radix Sort
  public static void radixSort(int[] arr) {
    int max = getMax(arr); // 최대값 확인
    int exp = 1; // 자릿수: 1, 10, 100, ...

    // 각 자릿수를 기준으로 정렬
    while (max / exp > 0) {
      countingSortByDigit(arr, exp);
      exp *= 10; // 다음 자릿수
    }
  }

  // Counting Sort by digit (자릿수를 기준으로 계수 정렬)
  private static void countingSortByDigit(int[] arr, int exp) {
    int[] output = new int[arr.length]; // 정렬 결과 저장용
    int[] count = new int[10]; // 0~9 계수 카운트

    // 현재 자릿수를 기준으로 count 배열 갱신
    for (int num : arr) {
      int digit = (num / exp) % 10; // 해당 자릿수의 숫자
      count[digit]++;
    }

    // 누적합 계산
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // 안정적인 정렬 수행 (뒤에서부터 삽입)
    for (int i = arr.length - 1; i >= 0; i--) {
      int digit = (arr[i] / exp) % 10; // 자릿수 추출
      output[count[digit] - 1] = arr[i];
      count[digit]--;
    }

    // 정렬된 결과를 원본 배열로 복사
    System.arraycopy(output, 0, arr, 0, arr.length);
  }

  // 배열에서 최대값 찾기
  private static int getMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) {
      max = Math.max(max, num);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    System.out.println("정렬 전:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();

    // Radix Sort 수행
    radixSort(arr);

    System.out.println("정렬 후:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
```

---

### 정렬 실행 결과
- **정렬 전 배열**:  `[170 45 75 90 802 24 2 66]`
- **정렬 후 배열**:  `[2 24 45 66 75 90 170 802]`

---

## 활용 예제

### 1. 대규모 데이터 정렬
- 자릿수(`k`)가 작을 경우 특히 효율적인 정렬 알고리즘입니다.
- **예시**: 우편번호, 전화번호, 학번 등 숫자로 구성된 데이터 정렬.

---

### 2. 안정적인 정렬이 필요한 경우
- 동일한 값을 가진 데이터의 기존 순서를 유지합니다.
- **예시**: 학생 점수 정렬(점수가 동일한 경우 학생 번호 유지).

---

### 3. 데이터를 클러스터링 방식으로 정렬
- 각 자릿수를 기준으로 데이터를 병렬적으로 나누고 정렬하여 효율성을 극대화.
- **예시**: 직접 구현 대신 Spark/MapReduce 기반 분산 처리에서도 활용.

---

## 참고
기수 정렬은 제한된 상황에서 효율적입니다(예: 숫자 중심의 정렬).  
하지만 자릿수(`k`)가 너무 크거나, 데이터가 숫자가 아닌 경우에는 퀵 정렬, 병합 정렬 등 대체 알고리즘을 고려해야 할 수 있습니다.
