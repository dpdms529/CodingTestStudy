#include <bits/stdc++.h>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
	return a.first < b.first;;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	vector<pair<int, int>> room;
	priority_queue<int, vector<int>, greater<int>> pq;

	cin >> n;
	for(int i=0;i<n;i++) {
		int s, t;
		cin >> s >> t;
		room.push_back({s, t});
	}

	sort(room.begin(), room.end(), cmp);

	// for(int i=0;i<room.size();i++) {
	// 	cout << room[i].first << " " << room[i].second << endl;
	// }
	pq.push(room[0].second);
	for(int i=1;i<room.size();i++) {
		if(pq.top() > room[i].first) {
			pq.push(room[i].second);
		} else {
			pq.pop();
			pq.push(room[i].second);
		}
	}
	cout << pq.size() << endl;
	while(!pq.empty()) {
		cout << pq.top() << " ";
		pq.pop();
	}
	return 0;
}