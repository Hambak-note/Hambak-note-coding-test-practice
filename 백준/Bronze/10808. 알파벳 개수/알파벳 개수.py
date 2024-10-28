'''
ord() : 주어진 문자의 Unicode 코드 포인트를 반환하는 파이썬 내장 함수
ord('a') = 97
'''

input_string = input()

count = [0] * 26

for char in input_string:
    count[ord(char) - ord('a')] += 1

print(" ".join(map(str, count)))