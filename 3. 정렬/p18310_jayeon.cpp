#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<int> house;
	for(int i=0;i<n;i++) {
		int x;
		cin >> x;
		house.push_back(x);
	}
	sort(house.begin(), house.end());

	if(n%2 == 0) {
		cout << house[n/2-1];
	}
	else cout << house[n/2];


	return 0;
}