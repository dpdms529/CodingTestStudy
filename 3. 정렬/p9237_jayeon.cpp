#include <bits/stdc++.h>

using namespace std;

bool cmp(pair <int, int> a, pair<int, int> b) {
	return a.first > b.first;
}
bool cmp_second(pair <int, int> a, pair<int, int> b) {
	return a.second > b.second;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<pair<int, int>> v;
	for(int i=0;i<n;i++) {
		int x;
		cin >> x;
		v.push_back({x, 0});
	}
	sort(v.begin(), v.end(), cmp);
	int left = n;
	for(int i=0;i<n;i++) {
		v[i].second = v[i].first - left + 1;
		left--;
	}
	sort(v.begin(), v.end(), cmp_second);
	// for(int i=0;i<n;i++) cout << v[i].first << ' ' << v[i].second << '\n';
	cout << v[0].second + n + 1;

	return 0;
}