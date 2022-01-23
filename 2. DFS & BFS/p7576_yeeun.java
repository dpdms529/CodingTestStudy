import java.util.*;
import java.io.*;

public class p7576 {
	
	public static int m,n;
	public static int graph[][];
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	public static ArrayList<int[]> start = new ArrayList<>();
	public static Queue<int[]> q = new LinkedList<>();
	
	public static int bfs(int i, int j) {
		int y = -1, x = -1;
		while(!q.isEmpty()) {
			int p[] = q.poll();
			y = p[0];
			x = p[1];
			for(int idx = 0;idx<4;idx++) {
				int ny = y + dy[idx];
				int nx = x + dx[idx];
				if(ny>=0 && ny<n && nx>=0 && nx<m) {
					if(graph[ny][nx] == 0) {
						q.offer(new int[] {ny,nx});
						graph[ny][nx] = graph[y][x] + 1;
					}
				}
			}
		}
		return graph[y][x];
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		int result = -1;
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 1) start.add(new int[] {i,j,0});
			}
		}
		
		if(start.size()>0) {
			for(int i = 0;i<start.size();i++) {
				int y = start.get(i)[0];
				int x = start.get(i)[1];
				q.offer(new int[] {y,x});
			}
			result = bfs(start.get(0)[0], start.get(0)[1]) - 1;	
		}

		loop: for(int i = 0;i<n;i++) {
			for(int j = 0; j<m;j++) {
				if(graph[i][j]==0) {
					result = -1;
					break loop; 
				}
			}
		}

		System.out.println(result);
	}

}
