#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	int count = 0;
	cin >> n >> k;
	vector<int> coin;
	for(int i=0;i<n;i++) {
		int tmp;
		cin >> tmp;
		coin.push_back(tmp);
	}
	for(int i=coin.size()-1;i>=0;i--) {
		if(k<coin[i]) continue;
		count += k/coin[i];
		k %= coin[i];
	}
	cout << count;

	return 0;
}