import java.util.*;
import java.io.*;

public class p14500 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//n : 세로 크기, m : 가로 크기
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//각 칸에 적힌 수
		int arr[][] = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//테트로미노가 놓인 칸에 쓰인 수들의 합의 최대값 구하기
		int max = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				max = tetromino(n,m,i,j,max,arr);
			}
		}
		System.out.println(max);
	}
	
	public static int tetromino(int n, int m, int y, int x, int max, int[][] arr) {
		for(int i = 0;i<19;i++) {
			int sum = 0;
			switch(i) {
			//****
			case 0:
				if(x+3<m) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y][x+3];
				}
				break;
			//*
			//*
			//*
			//*
			case 1:
				if(y+3<n) {
					sum = arr[y][x] + arr[y+1][x] + arr[y+2][x] + arr[y+3][x];
				}
				break;
			//**
			//**
			case 2:
				if(x+1<m && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y+1][x] + arr[y+1][x+1];
				}
				break;
			//*
			//*
			//**
			case 3:
				if(x+1<m && y+2<n) {
					sum = arr[y][x] + arr[y+1][x] + arr[y+2][x] + arr[y+2][x+1];
				}
				break;
			//  *
			//***
			case 4:
				if(x+2<m && y-1>-1) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y-1][x+2];
				}
				break;
			//**
			// *
			// *
			case 5:
				if(x+1<m && y+2<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y+1][x+1] + arr[y+2][x+1];
				}
				break;
			//***
			//*
			case 6:
				if(x+2<m && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y+1][x];
				}
				break;
			// *
			// *
			//**
			case 7:
				if(x+1<m && y-2>-1) {
					sum = arr[y][x] + arr[y][x+1] + arr[y-1][x+1] + arr[y-2][x+1];
				}
				break;
			//***
			//  *
			case 8:
				if(x+2<m && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y+1][x+2];
				}
				break;
			//**
			//*
			//*
			case 9:
				if(x+1<m && y+2<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y+1][x] + arr[y+2][x];
				}
				break;
			//*
			//***
			case 10:
				if(x+2<m && y+1<n) {
					sum = arr[y][x] + arr[y+1][x] + arr[y+1][x+1] + arr[y+1][x+2];
				}
				break;
			//*
			//**
			// *
			case 11:
				if(x+1<m && y+2<n) {
					sum = arr[y][x] + arr[y+1][x] + arr[y+1][x+1] + arr[y+2][x+1];
				}
				break;	
			// **
			//**
			case 12:
				if(x+2<m && y-1>-1) {
					sum = arr[y][x] + arr[y][x+1] + arr[y-1][x+1] + arr[y-1][x+2];
				}
				break;
			// *
			//**
			//*
			case 13:
				if(x+1<m && y-1>-1 && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y-1][x+1] + arr[y+1][x];
				}
				break;
			//**
			// **
			case 14:
				if(x+2<m && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y+1][x+1] + arr[y+1][x+2];
				}
				break;
			//***
			// *
			case 15:
				if(x+2<m && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y+1][x+1];
				}
				break;
			//*
			//**
			//*
			case 16:
				if(x+1<m && y+2<n) {
					sum = arr[y][x] + arr[y+1][x] + arr[y+2][x] + arr[y+1][x+1];
				}
				break;
			// *
			//***
			case 17:
				if(x+2<m && y-1>-1) {
					sum = arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y-1][x+1];
				}
				break;
			// *
			//**
			// *
			case 18:
				if(x+1<m && y-1>-1 && y+1<n) {
					sum = arr[y][x] + arr[y][x+1] + arr[y-1][x+1] + arr[y+1][x+1];
				}
				break;
			}
			if(sum > max) max = sum;
		}
		return max;
	}

}
