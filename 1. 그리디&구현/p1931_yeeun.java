import java.util.*;
import java.io.*;

public class p1931 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n : 회의 수
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//arr : 회의 정보 (arr[i][0] : 시작시간, arr[i][1] : 종료시간)
		int arr[][] = new int[n][2];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		//회의 종료 시간이 빠른 순서로 정렬, 회의 종료 시간이 같은 경우는 시작 시간이 빠른 순서로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] obj1, int[] obj2) {
				if(obj1[1] == obj2[1]) return obj1[0] - obj2[0];
				else return obj1[1] - obj2[1];
			}
		});
		//회의 시작 시간이 이전 회의 종료 시간 이후인 경우 cnt 값 1 증가
		int pre = 0, cnt = 0;
		for(int i = 0;i<n;i++) {
			if(arr[i][0] >= pre) {
				cnt++;
				pre = arr[i][1];
			}
		}
		System.out.println(cnt);
	}

}
