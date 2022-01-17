# 적록색약

import copy
import sys

# 재귀 깊이 변경 (안하면 런타임에러<RecursionError> 발생)
sys.setrecursionlimit(10**6)

# 입력받기
n = int(sys.stdin.readline())
right = []
check_right = []
for i in range(n):
    right.append(list(sys.stdin.readline().strip()))
    check_right.append([False]*n)

# 변수 설정
wrong = []
check_wrong = copy.deepcopy(check_right)
# G -> R
for i in range(n):
    tmp = []
    for j in range(n):
        if right[i][j] == 'G':
            tmp.append('R')
        else:
            tmp.append(right[i][j])
    wrong.append(tmp)


def dfs(x, y, color, check, paint):
    if x >= n or x < 0 or y >= n or y < 0:
        return False
    if not check[x][y] and paint[x][y] == color:
        check[x][y] = True
        dfs(x - 1, y, color, check, paint)
        dfs(x, y - 1, color, check, paint)
        dfs(x + 1, y, color, check, paint)
        dfs(x, y + 1, color, check, paint)
        return True


# 옳은 입력 답 구하기
result1 = 0
for i in range(n):
    for j in range(n):
        read = right[i][j]
        if dfs(i, j, read, check_right, right):
            result1 += 1
# 옳지 않은 입력 답 구하기
result2 = 0
for i in range(n):
    for j in range(n):
        read = wrong[i][j]
        if dfs(i, j, read, check_wrong, wrong):
            result2 += 1
# 답 출력
print('{} {}'.format(result1, result2))
