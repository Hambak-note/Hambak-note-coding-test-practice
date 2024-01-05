from typing import List

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


