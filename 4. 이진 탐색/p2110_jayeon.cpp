#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, c;
	cin >> n >> c;

	vector<int> v;
	for(int i=0;i<n;i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(), v.end());

	if(c==2) cout << v.back() - v.front();
	else {
		long long start = 0;
		long long end = v.size()-1;
		long long result = 0;
		while(start <= end) {
			long long gap = 0;
			long long mid = (start + end) / 2;
			if(v[mid] - v[mid-1] > result && v[mid+1]-v[mid] > result) {
				result = v[mid];
			}
			else if(v[mid] - v[mid-1] < v[mid+1] - v[mid]) {
				start = mid+1;
			}
			else if(v[mid] - v[mid-1] < v[mid+1] - v[mid]) {
				end = mid - 1;
			}
		}
		cout << result;
	}

	return 0;
}