n, m = map(int, input().split())
memo = {}

for _ in range(n):
    site, password = input().split()
    memo[site] = password

for _ in range(m):
    stie_url = input()
    print(memo.get(stie_url))