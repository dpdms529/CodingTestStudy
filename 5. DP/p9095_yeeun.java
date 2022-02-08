import java.util.*;
import java.io.*;

public class p9095 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int tc[] = new int[t];
		int dp[] = new int[11];
		for(int i = 0;i<t;i++) {
			tc[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4;i<11;i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int i = 0;i<t;i++) {
			System.out.println(dp[tc[i]]);
		}
	}

}
