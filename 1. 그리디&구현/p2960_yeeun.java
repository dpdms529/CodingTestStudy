import java.util.*;
import java.io.*;

public class p2960 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Boolean> arr = new ArrayList<>();
		
		for(int i = 0;i<=n;i++) {
			if(i<2) arr.add(false);
			else arr.add(true);
		}
		int cnt = 0;
		e:for(int i = 0;i<=n;i++) {
			if(arr.get(i)) {
				for(int j = i;j<=n;j+=i) {
					if(arr.get(j)) {
						cnt++;
						arr.set(j, false);
						if(cnt == k) {
							System.out.println(j);
							break e;
						}
					}
				}
			}
		}
	}
}
