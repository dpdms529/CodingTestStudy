import java.util.*;
import java.io.*;

public class p1644 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//소수찾기 - 에라토스테네스 체
		boolean arr[] = new boolean[n+1];
		ArrayList<Integer> prime = new ArrayList<>();
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		for(int i = 2;i<=Math.sqrt(n);i++) {
			if(arr[i]) {
				for(int j = i+i;j<=n;j+=i) {
					arr[j] = false;
				}	
			}
		}
		for(int i = 0;i<=n;i++) {
			if(arr[i]) prime.add(i);
		}
		
		//연속합이 n인 경우의 수 구하기 - 투포인터
		int cnt = 0;
		int sum = 0;
		int end = 0;
		int len = prime.size();
		for(int start = 0;start<len;start++) {
			while(sum<n && end<len) {
				sum += prime.get(end);
				end++;
			}
			if(sum == n) {
				cnt++;
			}
			sum -= prime.get(start);
		}
		System.out.println(cnt);
	}

}
