
test_case = int(input())
for _ in range(test_case):
    first_str, second_str = input().split()
    first_str = ''.join(sorted(first_str))
    second_str = ''.join(sorted(second_str))
    result = "Possible" if first_str == second_str else "Impossible"
    print(result)

