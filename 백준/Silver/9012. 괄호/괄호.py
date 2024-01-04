
def isVPS(input_str: str) -> bool:
    stack = []

    for cur in input_str:
        if cur == '(':
            stack.append(cur)
            continue
        
        if not stack and cur == ')':
            return False
        
        if cur == ')':
            stack.pop()
    
    return not stack

T = int(input())

while T > 0:
    T -= 1
    input_str = input()
    result = isVPS(input_str)
    if result:
        print("YES")
    else:
        print("NO")


