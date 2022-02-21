#include <bits/stdc++.h>

using namespace std;
int parent[204];

int findParent(int x) {
	if(x == parent[x]) {
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

	cin >> n >> m;
	for(int i=1;i<=n;i++) {
		parent[i] = i;
	}

	for(int i=1;i<=n;i++) {
		for(int j=1;j<=n;j++) {
			int x;
			cin >> x;
			if(x) {
				unionParent(i, j);
			}
		}
	}

	// for(int i=1;i<=n;i++) cout << parent[i] << '\n';

	int p;
	bool flag = true;
	for(int i=0;i<m;i++) {
		int x;
		cin >> x;
		if(!i) p = parent[x];
		else {
			if(p != parent[x]) {
				flag = false;
				break;
			}
		}
	}

	if(flag) cout << "YES";
	else cout << "NO";

	return 0;
}