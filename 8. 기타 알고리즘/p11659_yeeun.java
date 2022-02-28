import java.util.*;
import java.io.*;

public class p11659 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int prefixSum[] = new int[n+1];
		for(int i = 0;i<n;i++) {
			sum += arr[i];
			prefixSum[i+1] = sum;
		}
		for(int k = 0;k<m;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(prefixSum[j] - prefixSum[i-1]);
		}
	}

}
