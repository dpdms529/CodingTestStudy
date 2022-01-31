#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;
	for(int i=0;i<t;i++) {
		int n, m, x;
		cin >> n >> m;
		vector<int> a,b;
		for(int j=0;j<n;j++) {
			cin >> x;
			a.push_back(x);
		}
		for(int j=0;j<m;j++) {
			cin >> x;
			b.push_back(x);
		}

		// 
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());

		int cnt = 0;
		for(int j=0;j<n;j++) {
			int result = 0;
			int start = 0, end = m-1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(a[j] > b[mid]) {
					result = mid + 1;
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			// cout << "result: " << result << ", j: " << j << endl;
			cnt += result;
		}

		cout << cnt << '\n';

		// int cnt = 0;
		// for(int j=0;j<m;j++) {
		// 	cout << j << '\n';
		// 	int start = 0, end = n;
		// 	int result = 0;
		// 	while(start <= end) {
		// 		int mid = (start + end) / 2;
		// 		if(a[mid] > b[j]) {
		// 			end = mid - 1;
		// 			result = mid;
		// 		} else {
		// 			start = mid + 1;
		// 		}
		// 	}
		// 	cnt += result+1;
		// 	cout << cnt << '\n';
		// }

	}

	return 0;
}