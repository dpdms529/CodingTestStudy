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

		// a, b 각각 오름차순 정렬
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());

		int cnt = 0; // A의 크기가 B보다 큰 쌍 개수
		for(int j=0;j<n;j++) {
			int result = 0;
			int start = 0, end = m-1;
			// a 원소 각각에 대하여 b의 인덱스를 이분탐색함
			while(start <= end) {
				int mid = (start + end) / 2;
				if(a[j] > b[mid]) {
					// 현재 a값보다 b값이 더 작으면
					// 현재 b의 인덱스 이후의 값들과 현재 a값은 모두 쌍이 이뤄질 수 있으므로
					// 현재 인덱스 + 1만큼의 쌍이 이뤄질 수 있음
					// result와 start를 현재 b의 인덱스 + 1로 지정
					result = mid + 1;
					start = mid + 1;
				} else {
					// 현재 a값보다 b값이 같거나 크면 쌍이 이뤄질 수 없으므로
					// 더 작은(=인덱스가 더 작은) b값이 필요함
					end = mid - 1;
				}
			}
			// cout << "result: " << result << ", j: " << j << endl;
			cnt += result;
		}

		cout << cnt << '\n';

	}

	return 0;
}