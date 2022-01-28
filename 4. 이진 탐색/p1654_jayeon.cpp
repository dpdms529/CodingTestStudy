#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> k >> n;

	long long end = 0;
	vector<int> v;
	for(int i=0;i<k;i++) {
		int x;
		cin >> x;
		v.push_back(x);
		if(x > end) end = x; 
	}
	// cout << "end " << end;

	long long start = 1;
	long long result = 0;
	while(start <= end) {
		long long mid = (start + end) / 2;
		long long total = 0;
		for(int i=0;i<k;i++) {
			total += v[i]/mid;
		}
		if(total >= n) {
			result = mid;
			start = mid + 1;
		} else {
			end = mid - 1;
		}
	}
	cout << result;
	return 0;
}