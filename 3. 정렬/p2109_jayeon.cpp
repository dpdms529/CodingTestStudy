#include <bits/stdc++.h>

using namespace std;

bool cmp(pair <int, int> a, pair<int, int> b) {
	// if(a.second == b.second) {
	// 	return a.first > b.first;
	// }
	return a.first > b.first;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<pair<int, int>> v;
	for(int i=0;i<n;i++) {
		int x, y;
		cin >> x >> y;
		v.push_back({x, y});
	}
	sort(v.begin(), v.end(), cmp);

	int day = v[0].second;
	int income = v[0].first;

	for(int i=1;i<n;i++) {
		if(day >= v[i].second) {
			continue;
		}
		else {
			income += v[i].first;
			day = v[i].second;
		}
	}

	// cout << income;

	for(int i=0;i<n;i++) {
		cout << v[i].first << ' ' << v[i].second << '\n';
	}


	return 0;
}