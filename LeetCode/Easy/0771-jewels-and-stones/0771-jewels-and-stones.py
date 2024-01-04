class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        stones_map = {}
        result = 0

        for stone in stones:
            stones_map[stone] = stones_map.get(stone, 0) + 1
        
        for jewel in jewels:
            if jewel in stones_map:
                result += stones_map[jewel]

        return result