# 제로

import sys

k = int(sys.stdin.readline())
result = []
for i in range(k):
    n = int(sys.stdin.readline())
    if n != 0:
        result.append(n)
    else:
        result.pop()

print(sum(result))
