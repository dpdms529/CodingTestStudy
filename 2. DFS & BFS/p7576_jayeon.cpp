#include <bits/stdc++.h>

using namespace std;

int n, m;
int graph[1004][1004];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
queue<pair<int, int>> q;

void bfs() {
	while(!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if(graph[nx][ny] == -1) continue;
			if(graph[nx][ny] == 0) {
				graph[nx][ny] = graph[x][y] + 1;
				q.push({nx, ny});
			}
		}
	}
}


int main() {
	scanf("%d %d", &m, &n);
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			scanf("%d", &graph[i][j]);
			if(graph[i][j] == 1) {
				q.push({i, j});
			}
		}
	}
	bfs();
	// for(int i=0;i<n;i++) {
	// 	for(int j=0;j<m;j++) {
	// 		printf("(%d %d [%d]) ", i, j, graph[i][j]);
	// 	}
	// 	printf("\n");
	// }
	int result = 0;
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			if(graph[i][j] == 0) {
				printf("-1");
				return 0;
			}
			if(result < graph[i][j]) result = graph[i][j];
		}
	}
	printf("%d", result-1);

	return 0;
}