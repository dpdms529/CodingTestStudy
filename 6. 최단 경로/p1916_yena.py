# 최소비용 구하기
import heapq
import sys

# 입력
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[] * (n+1) for _ in range(n+1)]
# p = [[]] * (n+1)  # 이렇게 생성하면 안됨. 이상하게도 출력하면 형태는 똑같으나 삽입하면 다름
# print(graph)
# print(p)
for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    graph[s].append((e, c))
start, end = map(int, sys.stdin.readline().split())

# 다익스트라 알고리즘
distance = [int(1e9)] * (n+1)
q = []
heapq.heappush(q, (0, start))
distance[start] = 0

while q:
    dist, node = heapq.heappop(q)
    if distance[node] < dist:
        continue
    for n, d in graph[node]:
        cost = dist + d
        if cost < distance[n]:
            distance[n] = cost
            heapq.heappush(q, (cost, n))

print(distance[end])
