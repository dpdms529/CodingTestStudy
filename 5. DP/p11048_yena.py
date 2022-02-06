# 이동하기

import sys

n, m = map(int, sys.stdin.readline().split())
array = []
for _ in range(n):
    array.append(list(map(int, sys.stdin.readline().split())))

# 첫번째 행 더하기
for i in range(1, m):
    array[0][i] += array[0][i-1]
# 첫번째 열 더하기
for i in range(1, n):
    array[i][0] += array[i-1][0]

for i in range(1, n):
    for j in range(1, m):
        if array[i-1][j] > array[i][j-1]:
            array[i][j] += array[i-1][j]
        else:
            array[i][j] += array[i][j-1]

print(array[-1][-1])


