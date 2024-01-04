from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        index_stack = []
        output = [0] * len(temperatures)

        for i in range(len(temperatures)):
            while index_stack and temperatures[index_stack[-1]] < temperatures[i]:
                popped_index = index_stack.pop()
                output[popped_index] = i - popped_index

            index_stack.append(i)

        return output