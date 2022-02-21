#include <bits/stdc++.h>

using namespace std;

int parent[1004];

int findParent(int x) {
	if(parent[x] == x) {
		return x;
	}
	return parent[x] = findParent(parent[x]);
}

void unionParent(int a, int b) {
	a = findParent(a);
	b = findParent(b);
	if(a < b) parent[b] = a;
	else parent[a] = b;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	vector<pair<int, pair<int, int>>> edges;
	int result = 0;

	cin >> n >> m;

	for(int i=1;i<=n;i++) parent[i] = i;

	for(int i=0;i<m;i++) {
		int a, b, cost;
		cin >> a >> b >> cost;
		edges.push_back({cost, {a, b}});
	}

	sort(edges.begin(), edges.end());

	for(int i=0;i<edges.size();i++) {
		int cost = edges[i].first;
		int a = edges[i].second.first;
		int b = edges[i].second.second;

		if(findParent(a) != findParent(b)) {
			unionParent(a, b);
			result += cost;
		}
	}

	cout << result;

	return 0;
}