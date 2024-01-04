from queue import Queue

def solve_and_print_result(n, m, importance_values):
    importance = Queue()
    index = Queue()

    for j, val in enumerate(importance_values):
        importance.put(val)
        index.put(j)

    count = 1

    while not importance.empty():
        max_importance = max(importance.queue)
        cur_importance = importance.get()
        cur_index = index.get()

        if cur_importance == max_importance:
            if cur_index == m:
                print(count)
                break
            count += 1
        else:
            importance.put(cur_importance)
            index.put(cur_index)

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    importance_values = list(map(int, input().split()))
    
    solve_and_print_result(n, m, importance_values)
