import java.util.*;
import java.io.*;

public class p10815 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int card[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int m = Integer.parseInt(br.readLine());
		int target;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) {
			target = Integer.parseInt(st.nextToken());
			int start = 0, end = n-1;
			int result = 0;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(card[mid] == target) {
					result = 1;
					break;
				}else if(card[mid] > target) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
			System.out.print(result + " ");
		}
		
	}

}
