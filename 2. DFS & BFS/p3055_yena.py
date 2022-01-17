# 탈출

import sys
from collections import deque

r, c = map(int, sys.stdin.readline().split())
map = []
water = []  # 물이 있는 위치 저장하는 리스트
check = [True, True]  # 시작 위치와 끝나는 위치를 기록했는지 확인용
for i in range(r):
    tmp = list(sys.stdin.readline().strip())
    map.append(tmp)
    # 시작 위치 찾기
    if check[0]:
        for j in range(c):
            if tmp[j] == 'S':
                start = (i, j)
                check[0] = False
    # 도착 위치 찾기
    if check[1]:
        for j in range(c):
            if tmp[j] == 'D':
                end = (i, j)
                check[1] = False
    # 물 위치 찾기
    for j in range(c):
        if tmp[j] == '*':
            water.append((i, j))

# 이동할 네 가지 방향 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(queue):
    while queue:
        # D가 map에 없는지 확인
        noD = True
        for i in map:
            for j in i:
                if j == 'D':
                    noD = False
        # D가 없다면 S가 도착했다는 의미이므로 종료
        if noD:
            break

        x, y = queue.popleft()

        # 중복이라면 무시
        overlap = False
        for i, j in queue:
            if x == i and j == y:
                overlap = True
        if overlap:
            continue

        # x, y에서 네 방향으로 이동
        for i in range(4):
            # 다음으로 이동할 좌표
            nx = x + dx[i]
            ny = y + dy[i]

            # 공간을 벗어난 경우
            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                continue
            # 돌인 경우
            if map[nx][ny] == 'X':
                continue
            # 현재 위치가 물이 아니고 // 다음 위치가 빈칸이거나 도착지점이라면 이동
            if map[x][y] != '*' and (map[nx][ny] == '.' or map[nx][ny] == 'D'):
                map[nx][ny] = int(map[x][y]) + 1
                queue.append((nx, ny))
                continue
            # 현재 위치가 물이고 // 다음 위치가 물이나 도착지점이 아니라면 이동
            if map[nx][ny] != '*' and map[nx][ny] != 'D' and map[x][y] == '*':
                map[nx][ny] = '*'
                queue.append((nx, ny))


# 출발지를 0으로 세팅
x, y = start
map[x][y] = 0

# 큐에 출발지를 먼저 넣고 물을 넣음
queue = deque()
queue.append(start)
for i in water:
    queue.append(i)

# bfs 수행
bfs(queue)

# 도착지가 D라면 도착하지 못했음 // 숫자라면 잘 도착했음
x, y = end
if map[x][y] == 'D':
    print('KAKTUS')
else:
    print(map[x][y])
