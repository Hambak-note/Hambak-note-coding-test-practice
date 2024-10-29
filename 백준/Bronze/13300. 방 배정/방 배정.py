n, k = map(int, input().split())
arr = [[0] * 6 for _ in range(2)]

for _ in range(n):
    s, grade = map(int, input().split())
    arr[s][grade-1] += 1

room_count = sum(
    map(
        lambda row: sum(
            val // k + (1 if val % k != 0 else 0) for val in row
        ),
        arr
    )
)
print(room_count)