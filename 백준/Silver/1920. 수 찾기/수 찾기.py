n = int(input())
nArr = list(map(int, input().split()))
nArr.sort()

m = int(input())
targets = list(map(int, input().split()))

nValueSet = set()
for n in nArr:
    nValueSet.add(n)

for target in targets:
    if target in nValueSet:
        print(1)
        continue
    print(0)

