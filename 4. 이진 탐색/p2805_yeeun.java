import java.util.*;
import java.io.*;

public class p2805 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int start = 0;
		int end = Collections.max(arr);
		int result = 0;
		while(start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i = 0;i<n;i++) {
				if(arr.get(i) > mid) total += arr.get(i) - mid; 
			}
			if(total < m) end = mid - 1;
			else {
				result = mid;
				start = mid + 1;
			}
		}
		System.out.println(result);

	}

}
