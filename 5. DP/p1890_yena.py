# 점프

import sys

n = int(sys.stdin.readline())
array = []
for i in range(n):
    array.append(list(map(int, sys.stdin.readline().split())))

# 메모리 초과
# count = 0
# queue = deque()
# queue.append((0, 0))
# while queue:
#     x, y = queue.popleft()
#     if x == n-1 and y == n-1:
#         count += 1
#         continue
#     nx = x + array[x][y]
#     ny = y + array[x][y]
#     if nx < n:
#         queue.append((nx, y))
#     if ny < n:
#         queue.append((x, ny))
# print(count)

dp = [[0]*n for _ in range(n)]
dp[0][0] = 1

for x in range(n):
    for y in range(n):
        if x == n-1 and y == n-1:
            break
        if dp[x][y] >= 1:
            nx = x + array[x][y]
            ny = y + array[x][y]
            if nx < n:
                dp[nx][y] += dp[x][y]
            if ny < n:
                dp[x][ny] += dp[x][y]

print(dp[-1][-1])
