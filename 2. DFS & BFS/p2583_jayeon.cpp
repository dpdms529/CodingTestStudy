#include <bits/stdc++.h>

using namespace std;

int n, m;
int graph[104][104];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int dfs(int x, int y, int space) {
	if(x < 0 || x >= n || y < 0 || y >= m) return space;
	if(graph[x][y] == 0) {
		graph[x][y] = 1;
		space++;
		for(int i=0;i<4;i++) {
			space = dfs(x+dx[i], y+dy[i], space);
		}
	}
	return space;
}

int main() {
	int k;
	scanf("%d %d %d",&m, &n, &k);

	for(int i=0;i<k;i++) {
		int x1, x2, y1, y2;
		scanf("%d %d %d %d",&x1, &y1, &x2, &y2);
		for(int j=x1;j<x2;j++) {
			for(int h=y1;h<y2;h++) {
				graph[j][h] = 1;
			}
		}
	}

	// for(int i=0;i<n;i++) {
	// 	for(int j=0;j<m;j++) {
	// 		printf("(%d, %d [%d]) ",i, j, graph[i][j]);
	// 	}
	// 	printf("\n");
	// }
	priority_queue<int, vector<int>, greater<int>> pq;
	int count = 0;
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			int result = dfs(i,j,0);
			if(result > 0) {
				pq.push(result);
				count++;
			}
		}
	}
	printf("%d\n",count);
	while(!pq.empty()) {
		printf("%d ",pq.top());
		pq.pop();
	}

	return 0;
}