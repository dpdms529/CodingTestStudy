#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string str;
	cin >> str;
	int zero = 0, one = 0;
	for(int i=0;i<str.length();i++) {
		int tmp = str[i] - '0';
		if(i == str.length()-1) {
			if(tmp) one++;
			else zero++;
		} else {
			int next = str[i+1]-'0';
			if(tmp) { // tmp == 1
				if(next != tmp) one++;
			} else { // tmp == 0
				if(next != tmp) zero++;
			}
		}
	}
	if(one < zero) {
		cout << one;
	} else cout << zero;

	return 0;
}