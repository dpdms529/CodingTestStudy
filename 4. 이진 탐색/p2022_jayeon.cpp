#include <bits/stdc++.h>

using namespace std;

int main() {

	double x, y, c;
	scanf("%lf %lf %lf",&x, &y, &c);

	double low = 0;
	double high = min(x, y);
	double result = 0;

	while(high - low > 0.000001) {
		double mid = (high + low) / 2.0;
		double h1 = sqrt(x*x - mid*mid);
		double h2 = sqrt(y*y - mid*mid);

		double c_ = (h1*h2) / (h1+h2);
		if(c_ >= c) {
			result = mid;
			low = mid;
		} else high = mid;
	}
	printf("%.3lf\n",result);

	return 0;
}