from collections import Counter

first = input().strip()
second = input().strip()

count_first = Counter(first)
count_second = Counter(second)

count = sum(abs(count_first[char] - count_second[char]) 
            for char in set(count_first.keys()).union(set(count_second.keys())))

print(count)
