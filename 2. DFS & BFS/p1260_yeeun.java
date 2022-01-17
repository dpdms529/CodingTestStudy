import java.util.*;
import java.io.*;

public class p1260 {
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static boolean visited[];
	
	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for(int i = 0;i<graph.get(x).size();i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;
		while(!q.isEmpty()){
			int y = q.poll();
			System.out.print(y + " ");
			for(int i = 0;i<graph.get(y).size();i++) {
				int z = graph.get(y).get(i);
				if(!visited[z]) {
					q.offer(z);
					visited[z] = true;
				}
			}
		}
		
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1];
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph.get(f).add(t);
			graph.get(t).add(f);
		}
		
		for(int i = 1;i<=n;i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(v);
		visited = new boolean[n+1];
		System.out.println();
		bfs(v);
	}

}
