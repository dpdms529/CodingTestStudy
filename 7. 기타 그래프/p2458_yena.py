# 트리
import sys

# 입력
from copy import deepcopy

n = int(sys.stdin.readline())
parent = list(map(int, sys.stdin.readline().split()))
delNode = int(sys.stdin.readline())
top_parent = deepcopy(parent)
degree = [0] * n
for i in parent:
    if i == -1:
        continue
    degree[i] += 1
# 지울 노드 -1 && 부모 degree에서 1 빼기
degree[delNode] = -1
degree[parent[delNode]] -= 1


def find_parent(parent, x):
    if parent[x] == -1:
        return -1
    if parent[x] == delNode:
        return parent[x]
    parent[x] = find_parent(parent, parent[x])
    return parent[x]

for i in range(n):
    find_parent(top_parent, i)
for i in range(n):
    if top_parent[i] == delNode:
        degree[i] = -1
        degree[parent[i]] -= 1
result = 0
for i in degree:
    if i == 0:
        result += 1
print(result)
