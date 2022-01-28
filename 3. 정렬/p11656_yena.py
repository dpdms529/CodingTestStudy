# 접미사 배열

import sys

s = sys.stdin.readline().strip()
array = []

for i in range(len(s)):
    array.append(s[i:])

array.sort()
for i in array:
    print(i)
