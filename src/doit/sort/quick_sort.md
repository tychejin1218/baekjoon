# [알고리즘] 퀵 정렬 (Quick Sort)

**퀵 정렬**은 분할 정복(Divide and Conquer)을 활용하여 구현되는 효율적인 정렬 알고리즘입니다.  
피벗(Pivot)을 기준으로 배열을 두 그룹으로 나누고, 각 그룹을 재귀적으로 정렬합니다.

---

## 시간 복잡도
- **최선**: `O(N log N)` (균형 상태로 분할될 경우)
- **평균**: `O(N log N)`
- **최악**: `O(N²)` (분할이 편향된 경우, 예: 이미 정렬된 데이터에서 최댓값 또는 최솟값을 피벗으로 선택)

---

## 특징
- **빠른 평균 성능**: 대규모 데이터에 대해 매우 효율적.
- **불안정 정렬 (Unstable Sort)**: 동일한 값들의 상대 순서가 바뀔 수 있음.
- 추가 메모리 사용이 적은 **제자리 정렬(In-place Sort)**.

---

## 실행 흐름 (단계별 설명)

### 정렬 대상 배열: `[5, 3, 8, 4, 2]`
1. 초기 호출: `quickSort(arr, 0, 4)`  
   **low = 0**, **high = 4**, 피벗 = `2`.

#### 1단계: `partition(arr, low=0, high=4)`
- **현재 배열 상태**: `[5, 3, 8, 4, 2]`
- 피벗(Pivot): `2`
- 탐색: `5 > 2` → 아무것도 하지 않음.  
  `3 > 2` → 아무것도 하지 않음.  
  `8 > 2` → 아무것도 하지 않음.  
  `4 > 2` → 아무것도 하지 않음.
- 피벗(2)을 왼쪽으로 이동: `[2, 3, 8, 4, 5]`  
  **결과:** 피벗 `2`를 기준으로 분할 → `[2] | [3, 8, 4, 5]`

---

#### 2단계: 왼쪽과 오른쪽 부분 배열 재귀

**왼쪽 배열**: `[2]` 이미 크기가 1이므로 정렬 완료  
**오른쪽 배열**: `[3, 8, 4, 5]` → `quickSort(arr, low=1, high=4)`

---

#### 3단계: `partition(arr, low=1, high=4)`
- **현재 배열 상태**: `[2, 3, 8, 4, 5]`
- 피벗(Pivot): `5`
- 탐색: `3 < 5` → 그대로 둠.  
  `8 > 5` → 아무것도 하지 않음.  
  `4 < 5` → 값 교환: `[2, 3, 4, 8, 5]`.
- 피벗(5)을 제자리에 삽입: `[2, 3, 4, 5, 8]`  
  **결과:** 피벗 `5`를 기준으로 분할 → `[3, 4] | [8]`

---

#### 4단계: 추가 재귀 호출

**왼쪽 배열**: `[3, 4]` → `quickSort(arr, low=1, high=2)`  
**오른쪽 배열**: `[8]` 이미 정렬 완료.

---

#### 5단계: `partition(arr, low=1, high=2)`
- **현재 배열 상태**: `[2, 3, 4, 5, 8]`
- 피벗(Pivot): `4`
- 탐색: `3 < 4` → 그대로 둠.
- 피벗(4)은 이미 정렬된 상태.  
  **결과:** `[2, 3, 4, 5, 8]`

**최종 결과:** `[2, 3, 4, 5, 8]`

---

## 코드 예제

```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1); // 왼쪽 부분 배열 정렬
            quickSort(arr, pivotIndex + 1, high); // 오른쪽 부분 배열 정렬
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 마지막 요소를 피벗으로 선택
        int i = low - 1; // 피벗보다 작은 요소의 끝 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++; // 작은 값을 발견하면 i를 증가시키고, 교환
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗과 i+1 위치의 요소를 교환
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 피벗의 새로운 위치 반환
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

## 실행 예제

**정렬 대상 배열**: `[5, 3, 8, 4, 2]`

### 동작 과정
1. 초기 배열: `[5, 3, 8, 4, 2]`
2. 첫 번째 분할: `[2] | [3, 8, 4, 5]`
3. 두 번째 분할: `[2] | [3, 4] | [5, 8]`
4. 최종 배열: `[2, 3, 4, 5, 8]`

**결과 출력:** `2 3 4 5 8`

---

## 활용 예제

### 1. 대규모 데이터 정렬
- 대량의 데이터(예: 수천만 개의 요소)를 메모리 효율적으로 빠르게 정렬할 때 사용.
- 퀵 정렬은 데이터 크기와 상관없이 성능이 좋음.

---

### 2. 일상적인 배열 정렬
- 배열 크기가 큰 경우와 데이터가 무작위로 섞여 있는 경우 퀵 정렬이 효과적.
- 예: `[45, 50, 12, 38, 100, 1, 2]` 등을 정렬.

---

### 3. 구현 최적화
- 퀵 정렬은 대규모 정렬 라이브러리에서도 핵심 알고리즘의 일부로 구현됩니다.
- 예: Java의 `Arrays.sort()`는 내부적으로 퀵 정렬과 병합 정렬을 조합하여 사용.

---

## 참고
퀵 정렬은 효과적인 알고리즘으로 널리 사용되지만, 최악 시간 복잡도인 `O(N²)`을 방지하기 위해 **난수 피벗 선택**과 같이 최적화 기법을 사용하는 경우가 많습니다.
