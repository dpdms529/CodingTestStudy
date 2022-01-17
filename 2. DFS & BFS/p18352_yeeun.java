import java.util.*;
import java.io.*;

public class p18352 {

	public static int n, m, k;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int visited[];
	
	public static ArrayList<Integer> bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		ArrayList<Integer> city = new ArrayList<>();
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i = 0;i<graph.get(x).size();i++) {
				int y = graph.get(x).get(i);
				if(visited[y] == 0 && y != start) {
					visited[y] = visited[x] + 1;
					queue.offer(y);
					if(visited[y] == k) city.add(y+1);
				}
			}
		}
		return city;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i =0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new int[n];
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			graph.get(from).add(to);
		}
		
		ArrayList<Integer> city = bfs(x);
		if(city.size() == 0) System.out.println(-1);
		else {
			Collections.sort(city);
			for(int i = 0;i<city.size();i++) {
				System.out.println(city.get(i));
			}
		}
	}

}
