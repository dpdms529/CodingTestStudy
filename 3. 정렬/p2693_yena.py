# n번째 큰 수

import sys

t = int(sys.stdin.readline())

for i in range(t):
    a = list(map(int, sys.stdin.readline().split()))
    a.sort(reverse=True)
    print(a[2])
