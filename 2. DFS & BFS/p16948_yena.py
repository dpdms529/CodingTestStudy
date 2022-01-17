# 데스 나이트

import sys
from collections import deque

n = int(sys.stdin.readline())
r1, c1, r2, c2 = map(int, sys.stdin.readline().split())
map = []
for i in range(n):
    map.append([0] * n)

# 이동할 수 있는 방향 정의
dx = [-2, -2, 0, 0, 2, 2]
dy = [-1, 1, -2, 2, -1, 1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 벗어나는 경우 무시
            if nx >= n or nx < 0 or ny >= n or ny < 0:
                continue
            # 처음 방문하는 경우에만 기록
            if map[nx][ny] == 0:
                map[nx][ny] = map[x][y] + 1
                queue.append((nx, ny))


bfs(r1, c1)
if map[r2][c2] == 0:
    print(-1)
else:
    print(map[r2][c2])
