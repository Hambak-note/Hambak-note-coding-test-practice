

## 1. 문제 설명

N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

<br>

_입력 예시_
```text
5 // N
4 1 5 2 3 //N개의 정수
5 //M
1 3 7 9 5 //M개의 정수
```

<br>

_출력 예시_
```text
1 // 1은 N개의 정수에서 1개 있다.
1 // 3은 N개의 정수에서 1개 있다.
0 // 7은 N개의 정수에 없다.
0 // 9는 N개의 정수에 없다.
1 // 5는 N개의 정수에 1개 있다.
```

<br>


### 2. 문제 풀이

<br>

[첫 번째 방법 - 완전 탐색]
- M개의 정수가 들어있는 배열의 각 항목마다 N개의 정수가 들어있는 배열에서 값이 존재하는지 확인한다.
- 2중 for문을 사용하여 탐색한다.O(N^2)
- 제출 결과: 시간 초과

_소스코드_
```python
from typing import List

def brute_force_search(nArr: List[int], target: int) -> int:

    for val in nArr:
        if target == val:
            return 1
    return 0



n = int(input())
nArr = list(map(int, input().split()))

m = int(input())
targets = list(map(int, input().split()))

for target in targets:
    print(brute_force_search(nArr, target))
```

<br>

[두 번째 방법 - 이진 탐색]
- 이진 탐색은 오름차순 혹은 내림차순으로 정렬된 수열에서 값을 검색하는 알고리즘
- 기준값(중간값)을 정하고 수열을 절반으로 줄여나가면서 탐색하기 때문에 O(logn) 시간 복잡도를 가진다.
- 시간 복잡도
   - 정렬: O(nlogn) <- 파이썬은 Tim sort를 사용
   - target에 대해 이진 탐색을 수행했을 때: O(m log n)
      - 이진 탐색의 시간 복잡도 log n 이며 이를 m번 반복하기 때문
    - 총 시간 복잡도: O(N log N)
- 제출 결과: 정답(508ms)

_탐색 방법 설명_
- 배열의 이름을 arr로 가정
- 탐색 범위를 지정하는 인덱스 left, right를 사용
- 초기에 left = 배열의 첫 번째 인덱스, right = 배열의 마지막 인덱스
   - left = 0 , right = len(arr)-1
- 탐색 범위의 중간값 인덱스를 저장하는 mid 변수 사용

<br>

중요: 탐색을 시작하기 전 탐색하고자 하는 배열을 꼭 정렬해야 한다.
 
1. 배열의 가운데 요소의 인덱스를 mid에 저장한다.
2. arr[mid]의 값이 찾고자 하는 요소와 같다면 검색완료
3. arr[mid]이 찾는 값보다 크다면 left ~ mid 사이를 탐색한다.
   - 여기서 right에 mid의 값을 할당해서 left ~ right 사이의 범위를 절반으로 줄인다.
4. arr[mid]이 찾는 값보다 작다면 mid ~ right 사이를 탐색한다.
   - 여기서 left에 mid의 값을 할당해서 left ~ right 사이의 범위를 절반으로 줄인다.
5. left <= right가 될 때 까지 반복한다.(while문 사용)

<br>

_소스 코드_
```python
def binary_search(nArr: List[int], target: int) -> int:
    left, right = 0, len(nArr) - 1

    while(left <= right):
        mid = (left + right) // 2

        if nArr[mid] == target:
            return 1 # EXIST
        elif nArr[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return 0 # NOT_EXIST

n = int(input())
nArr = list(map(int, input().split()))
nArr.sort()

m = int(input())
targets = list(map(int, input().split()))

for target in targets:
    print(binary_search(nArr, target))
```

<br>

[Set을 사용하여 값이 존재하는 지 확인]
- 주어진 nArr의 값들을 set에 저장한다.
- M개의 값들을 반복하면서 set에 해당하는 값이 존재하면 '1'을 출력 아니면 '0'을 출력한다.
- 시간복잡도
   - nArr의 각 요소를 nValueSet에 추가하는데 필요한 시간 : O(n)
   - for target in targets: <- 타겟을 확잉ㄴ하는 반복문 : O(m)
   - set에서 값을 찾는 시간: O(1)
   - 총 시간 복잡도: O(n+m) => O(N) 
- 제출결과: 정답(176ms)

<br>

```python
n = int(input())
nArr = list(map(int, input().split()))
nArr.sort()

m = int(input())
targets = list(map(int, input().split()))

nValueSet = set()
for n in nArr:
    nValueSet.add(n)

for target in targets:
    if target in nValueSet:
        print(1)
        continue
    print(0)
```
