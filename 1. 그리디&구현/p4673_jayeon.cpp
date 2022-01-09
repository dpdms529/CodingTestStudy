#include <bits/stdc++.h>

using namespace std;

bool arr[10004];

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for(int i=1;i<=10000;i++){
		int tmp = 0;
		if(i >= 100) {
			if(i < 1000) {
				tmp = i + i/100 + (i%100)/10 + (i%100)%10;
			} else {
				tmp = i + i/1000 + (i%1000)/100 + ((i%1000)%100)/10 + ((i%1000)%100)%10;
			}
		} else {
			if(i < 10) tmp = i + i;
			else tmp = i + i/10 + i%10;
		}
		if(tmp <= 10000) arr[tmp] = true;
	}
	for(int i=1;i<=10000;i++) {
		if(!arr[i]) cout << i << '\n';
	}


	return 0;
}