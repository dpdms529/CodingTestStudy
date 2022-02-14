#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int v, e, k;
vector<pair<int, int>> graph[300004];
int d[300004];

void dijkstra(int start) {
	priority_queue<pair<int, int>> pq;

	pq.push({0, start});
	d[start] = 0;

	while(!pq.empty()) {
		int dist = -pq.top().first;
		int now = pq.top().second;
		pq.pop();

		if(d[now] < dist) continue;

		for(int i=0;i<graph[now].size();i++) {
			int cost = dist + graph[now][i].second;
			if(cost < d[graph[now][i].first]) {
				d[graph[now][i].first] = cost;
				pq.push(make_pair(-cost, graph[now][i].first));
			}
		}
	}
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> v >> e >> k;

	for(int i=0;i<e;i++) {
		int u, v_, w;
		cin >> u >> v_ >> w;
		graph[u].push_back({v_, w});
	}

	fill_n(d, 20004, INF);

	dijkstra(k);

	for(int i=1;i<=v;i++) {
		if(d[i] == INF) {
			cout << "INF\n";
		} else {
			cout << d[i] << '\n';
		}
	}

	return 0;
}