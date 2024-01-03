​


[풀이 코드]
```python
from typing import List
import collections

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list)

        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
        return list(anagrams.values())
```

<br>

- `anagrams = collections.defaultdict(list)`
   - collections 모듈에서 제공하는 defaultdict 클래스를 사용하여 딕셔너리를 생성
   - 기본값으로 빈 리스트(list())를 갖도록 생성
 
<br>

- `anagrams[''.join(sorted(word))].append(word)`
   - sorted(word): 문자열 word의 각 문자를 정렬한 리스트를 반환
   - join: 정렬된 문자들을 하나의 문자열로 합침
      - ''.join으로 사용한 이유는 '' 없이 그냥 join을 하게 되면 각 문자 사이에 공백이 추가된 리스트를 반환
      - 예시: join(sorted(word)), word가 "eat"인 경우
         - join(sorted(word)): 'a e t'
         - ''.join(sorted(word)): 'aet'
   - anagrams[''.join(sorted(word))]: 정렬된 문자열을 키로 하는 딕셔너리 anagrams에서 해당 키에 해당하는 값에 접근
   - append(word): 원래 단어 word를 해당 키에 해당하는 값에 추가
