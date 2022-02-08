#include <bits/stdc++.h>

using namespace std;

int dp[100004];

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for(int i=2;i<=n;i++) {
		dp[i] = dp[i-1] + 1;

		if(i%2 == 0) {
			dp[i] = min(dp[i/2]+1, dp[i]);
		}
		if(i%3 == 0) {
			dp[i] = min(dp[i/3]+1, dp[i]);
		}
	}
	cout << dp[n];

	return 0;
}