​

## 1. 문제 소개

<br>

현재 위치 기준으로 몇 일이 지나야 더 기온이 높아 지는지 구하는 문제

<br>

<예시>
```text
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

<img src = "https://github.com/Hambak-note/coding-test-practice/assets/104403136/de51b50c-729f-4d71-9ed0-d050cdccb35e" width="70%">



<br>
<br>


## 2. 문제 풀이

<br>

- output : 결과를 저장
- indexStack : 각 기온에 해당하는 index(=날짜)를 저장하는 스택

<br>

- for문을 통해 temperatures를 순서대로 돌면서(반복계수 : i)
   1.  지난 기온보다 현재 기온이 높으면 차이나는 일수를 result에 저장한다.
       - 지난 기온 값: temperatures[indexStack[-1]]
       - 현재 기온 값: temperatures[i]
       - 지난 기온보다 현재 기온이 높은 경우 판단: temperatures[indexStack[-1]] < temperatures[i]
       - 차이나는 일수 계산: 현재 기온 값 - 지난 기온 값
  2. 현재 기온의 index(=날짜)를 indexStack에 저장

<br>

[소스 코드]
```python
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
```

 <br>

 [동작 방식 그림으로 설명]

 <br>

<img src="https://github.com/Hambak-note/coding-test-practice/assets/104403136/f16c15d0-9060-4ca4-a5ac-6114ef1ce548">
<img src="https://github.com/Hambak-note/coding-test-practice/assets/104403136/4ddfbc6d-8b60-4a21-9fb8-fe9301ec9d41">
<img src="https://github.com/Hambak-note/coding-test-practice/assets/104403136/33788008-7ddc-4c85-8e0e-ff901a679cde">
