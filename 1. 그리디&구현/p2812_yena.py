# 크게 만들기

import sys

n, k = map(int, sys.stdin.readline().split())
number = list(sys.stdin.readline().strip())
K, result = k, []

# for i in range(n-k, -1, -1):
#     l = number[:len(number)-i]
#     l.sort(reverse=True)
#     max = l[0]
#     result.append(max)
#     index = number.index(max)
#     del number[:index+1]

for i in range(n):
    while k > 0 and result and result[-1] < number[i]:
        result.pop()
        k -= 1
    result.append(number[i])

print(''.join(result[:n-K]))
