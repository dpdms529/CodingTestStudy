import java.util.*;
import java.io.*;

public class p1475 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int arr[] = {1,1,1,1,1,1,1,1,1,1};
		int cnt = 1;
		for(int i = 0;i<n.length();i++) {
			int num = n.charAt(i)-'0';
			if(arr[num] == 0) {
				if((num == 6 && arr[9] > 0) || (num == 9 && arr[6] > 0)) {
					if(num == 6) arr[9]--;
					else arr[6]--;
				}
				else {
					arr[num]--;
					for(int j = 0;j<10;j++) arr[j]++;
					cnt++;
				}
			}else {
				arr[num]--;
			}
		}
		System.out.println(cnt);
	}

}
