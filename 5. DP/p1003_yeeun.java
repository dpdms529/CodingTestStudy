import java.util.*;
import java.io.*;

public class p1003 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int tc[] = new int[t];
		int zero[] = new int[41];
		int one[] = new int[41];
		for(int i = 0;i<t;i++) {
			tc[i] = Integer.parseInt(br.readLine());
		}
		zero[0] = 1;
		one[1] = 1;
		for(int i = 2;i<41;i++) {
			zero[i] = zero[i-2] + zero[i-1];
			one[i] = one[i-2] + one[i-1];
		}
		for(int i = 0;i<t;i++) {
			System.out.println(zero[tc[i]] + " " + one[tc[i]]);
		}
		
	}

}
