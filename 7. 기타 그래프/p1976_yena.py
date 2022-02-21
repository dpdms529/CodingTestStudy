# 여행 가자 - 서로소 집합
import sys


# 부모 찾는 함수
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 입력
n = int(sys.stdin.readline())  # 도시 수
m = int(sys.stdin.readline())  # 여행 계획에 속한 도시 수
graph = [[] for _ in range(n+1)]  # 도시 연결 그래프
for i in range(1, n+1):
    tmp = list(map(int, sys.stdin.readline().split()))
    for j in range(len(tmp)):
        if tmp[j] == 1:
            graph[i].append(j+1)
# print(graph)
plan = list(map(int, sys.stdin.readline().split()))  # 여행 계획

parent = [0] * (n+1)  # 부모 테이블
# 부모 테이블을 자신으로 초기화
for i in range(1, n+1):
    parent[i] = i

# graph에 대해 union 수행
for i in range(1, n+1):
    for j in graph[i]:
        union(parent, i, j)

top = parent[plan[0]]  # 첫번째 여행 도시의 부모 확인
flag = True  # 여행 가능 여부
for i in range(1, len(plan)):
    if top != parent[plan[i]]:
        flag = False
        print('NO')
        break
if flag:
    print('YES')
