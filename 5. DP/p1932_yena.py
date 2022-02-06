# 정수 삼각형

import sys

n = int(sys.stdin.readline())
array = []
for i in range(n):
    array.append(list(map(int, sys.stdin.readline().split())))

# 탑다운
# for i in range(len(array)-1):
#     for j in range(len(array[i])):
#         left = array[i][j] + array[i + 1][j]
#         right = array[i][j] + array[i + 1][j + 1]
#         if j == 0:  # 현재 맨 왼쪽 값이면
#             array[i + 1][j] = left
#         else:
#             array[i + 1][j] = max(array[i + 1][j], left)
#         array[i + 1][j + 1] = right
# print(array[-1])

# 바텀업
for i in range(len(array)-1, 0, -1):
    for j in range(len(array[i])-1):
        if array[i][j] > array[i][j+1]:
            array[i-1][j] += array[i][j]
        else:
            array[i-1][j] += array[i][j+1]

print(array[0][0])

