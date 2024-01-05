from typing import List
import collections
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # 아래와 같이 초기화하면 딕셔너리의 기본 값을 0으로 설정함
        nums_count_map = collections.defaultdict(int)

        for num in nums:
            nums_count_map[num] += 1
        
        max_heap = [(-count, num) for num, count in nums_count_map.items()]
        heapq.heapify(max_heap)

        output = [heapq.heappop(max_heap)[1] for _ in range(k)]

        return output