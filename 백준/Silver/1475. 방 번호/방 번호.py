
room = int(input())

nums = list(str(room))
arr = [0] * 10

for num in nums:
    arr[int(num)] += 1

six_plus_nine = 0
max_value = 0
for i in range(len(arr)):
    if i == 6 or i == 9:
        six_plus_nine += arr[i]
    else:
        max_value = max(arr[i], max_value)

six_plus_nine = (six_plus_nine // 2) + (six_plus_nine % 2)
max_value = max(max_value, six_plus_nine)

print(max_value)