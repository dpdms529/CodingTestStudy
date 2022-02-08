import java.util.*;
import java.io.*;
	
public class p1149 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cost[][] = new int[n][3];
		int dp[][] = new int[n][3];
		for(int i = 0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = cost[i][j];
			}
		}

		for(int i = 1;i<n;i++) {
			for(int j = 0;j<3;j++) {
				if(j == 0) {
					dp[i][j] = dp[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
				}else if(j == 1) {
					dp[i][j] = dp[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
				}else {
					dp[i][j] = dp[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0;i<3;i++) {
			result = Math.min(result, dp[n-1][i]);
		}
		System.out.println(result);

	}

}
