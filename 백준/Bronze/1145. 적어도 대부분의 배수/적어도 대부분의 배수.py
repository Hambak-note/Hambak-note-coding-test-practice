
arr = list(map(int, input().split()))
cur_value = min(arr)

while True:
    count = 0

    for value in arr:
        if(cur_value % value == 0):
            count += 1

    if count >= 3:
        print(cur_value)
        break

    cur_value += 1

