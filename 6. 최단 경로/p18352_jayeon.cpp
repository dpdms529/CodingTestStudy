#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int n, m;
vector<pair<int, int>> graph[300001];
int d[300001];

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

	int k, x;

	cin >> n >> m >> k >> x;
	for(int i=0;i<m;i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back({b, 1});
	}
	fill_n(d, 300001, INF);

	dijkstra(x);

	vector<int> v;
	int flag=0;
	for(int i=1;i<=n;i++) {
		if(d[i] == k) {
			cout << i << '\n';
			flag = 1;
		}
	}

	if(!flag) cout << -1 << '\n';

	return 0;
}