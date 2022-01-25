#include <bits/stdc++.h>

using namespace std;

bool cmp(pair <int, int> a, pair<int, int> b) {
	if(a.first == b.first) {
		return a.second < b.second;
	}
	return a.first > b.first;
}

bool check[10004];

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

	int income = 0;

	for(int i=0;i<v.size();i++) {
		for(int j=v[i].second;j>0;j--) {
			if(!check[j]) {
				income += v[i].first;
				check[j] = true;
				break;
			}
		}
	}

	cout << income;


	return 0;
}