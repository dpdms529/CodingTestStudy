import java.util.*;
import java.io.*;

public class p1806 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int sum = 0;
		int min = 100000;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int start = 0;start<n;start++) {
			while(sum<s && end<n) {
				sum += arr[end];
				end++;
			}
			if(sum >= s) {
				int len = end-start;
				if(len<min) {
					min = len;
				}
			}
			sum -= arr[start];
		}
		if(min==100000) System.out.println(0);
		else System.out.println(min);
	}

}
