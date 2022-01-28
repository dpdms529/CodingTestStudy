# 암기왕

import sys
from bisect import bisect_right, bisect_left

t = int(sys.stdin.readline())
for i in range(t):
    n = int(sys.stdin.readline())
    note1 = list(map(int, sys.stdin.readline().split()))
    m = int(sys.stdin.readline())
    note2 = list(map(int, sys.stdin.readline().split()))
    note1.sort()
    for j in note2:
        # note1.count(j)를 사용하면 시간초과
        if bisect_right(note1, j) - bisect_left(note1, j) == 0:
            print(0)
        else:
            print(1)
