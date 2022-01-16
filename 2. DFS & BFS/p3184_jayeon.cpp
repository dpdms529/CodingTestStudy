#include <bits/stdc++.h>

using namespace std;

string graph[254];
bool visited[254][254];
int sheep = 0, wolf = 0, r, c;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void bfs(int x, int y) {
	int curSheep = 0, curWolf = 0;

	queue<pair<int, int>> q;
	q.push({x, y});
	visited[x][y] = true;

	if(graph[x][y] == 'o') curSheep++;
	else if(graph[x][y] == 'v') curWolf++;
	
	while(!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
				continue;
			}
			if(graph[nx][ny] == '#') continue;
			if(!visited[nx][ny]) {
				if(graph[nx][ny] == 'v') curWolf++;
				else if(graph[nx][ny] == 'o') curSheep++;
				q.push({nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
	if(curSheep > curWolf) {
		wolf -= curWolf;
	} else {
		sheep -= curSheep;
	}
}

int main() {
	scanf("%d %d",&r, &c);

	for(int i=0;i<r;i++) {
		cin >> graph[i];
		for(int j=0;j<c;j++) {
			if(graph[i][j] == 'o') sheep++;
			else if(graph[i][j] == 'v') wolf++;
		}
	}

	for(int i=0;i<r;i++) {
		for(int j=0;j<c;j++) {
			if((graph[i][j] == 'o' || graph[i][j] == 'v') && !visited[i][j]) {
				bfs(i, j);
			}
		}
	}
	printf("%d %d",sheep, wolf);

	return 0;
}