package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1992_쿼드트리 {
	public static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			
			for(int j =0; j<N; j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		
		print(0,0,N);
		System.out.println(sb);
		
	}

	public static void print(int x, int y , int N) {
		
		if(check(x,y,N)) {
			sb.append(arr[x][y]);
			return;
		}
		
		int tmp = N/2;
		
		sb.append('(');
		
		print(x,y,tmp);
		print(x,y+tmp,tmp);
		print(x+tmp,y,tmp);
		print(x+tmp,y+tmp,tmp);
		
		sb.append(')');
	}
	
	public static boolean check (int x, int y, int size) {
		int tmp = arr[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(tmp != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
