import java.util.*;
import java.io.*;

public class p2512 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int start = 0, end = Collections.max(Arrays.asList(arr));
		int result = 0;
		while(start <= end) {
			int total = 0;
			int mid = (start + end) / 2;
			for(int i = 0;i<n;i++) {
				if(arr[i] <= mid) total += arr[i];
				else total += mid;
			}
			if(total > m) {
				end = mid - 1;
			}else {
				start = mid + 1;
				result = mid;
			}
		}
		System.out.println(result);
	}

}
