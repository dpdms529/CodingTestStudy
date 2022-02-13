# 파티
import heapq
import sys

# 입력
n, m, x = map(int, sys.stdin.readline().split())
graph = [[] * (n+1) for _ in range(n+1)]
for _ in range(m):
    s, e, t = map(int, sys.stdin.readline().split())
    graph[s].append((e, t))

# 다익스트라 알고리즘 (각자 집부터 x까지)
n_x_dist = [int(1e9)] * (n+1)

for i in range(1, n+1):
    tmp_dist = [int(1e9)] * (n + 1)
    tmp_q = []
    heapq.heappush(tmp_q, (0, i))
    tmp_dist[i] = 0
    while tmp_q:
        dist, node = heapq.heappop(tmp_q)
        if tmp_dist[node] < dist:
            continue
        for N, d in graph[node]:
            cost = dist + d
            if cost < tmp_dist[N]:
                tmp_dist[N] = cost
                heapq.heappush(tmp_q, (cost, N))
    # print(tmp_dist[x])
    n_x_dist[i] = tmp_dist[x]

# 다익스트라 알고리즘 (x부터 각자 집까지)
x_n_dist = [int(1e9)] * (n+1)
q = []
heapq.heappush(q, (0, x))
x_n_dist[x] = 0

while q:
    dist, node = heapq.heappop(q)
    if x_n_dist[node] < dist:
        continue
    for N, d in graph[node]:
        cost = dist + d
        if cost < x_n_dist[N]:
            x_n_dist[N] = cost
            heapq.heappush(q, (cost, N))

# print(n_x_dist)
# print(x_n_dist)
distance = [0] * (n+1)
for i in range(1, n+1):
    distance[i] = x_n_dist[i] + n_x_dist[i]

print(max(distance))
