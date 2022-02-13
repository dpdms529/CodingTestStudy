# 최단경로
import heapq
import sys

v, e = map(int, sys.stdin.readline().split())   # 정점, 간선 수
k = int(sys.stdin.readline())   # 시작점
graph = [[] * (v+1) for _ in range(v+1)]
distance = [int(1e9)] * (v+1)
for _ in range(e):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))

# 다익스트라 알고리즘, 우선순위 큐
q = []
heapq.heappush(q, (0, k))   # 큐에 거리와 시작점 push
distance[k] = 0
while q:
    dist, node = heapq.heappop(q)   # 큐에서 거리가 제일 작은걸 pop
    if distance[node] < dist:   # 방문한 노드면 continue
        continue
    for i in graph[node]:
        d, n = i[1], i[0]
        cost = dist + d
        if cost < distance[n]:
            distance[n] = cost
            heapq.heappush(q, (cost, n))

for i in range(1, len(distance)):
    if distance[i] < int(1e9):  # 갈 수 있으면 거리 출력
        print(distance[i])
    else:   # 갈 수 없으면 INF 출력
        print('INF')
