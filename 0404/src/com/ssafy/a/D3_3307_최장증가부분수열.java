package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D3_3307_최장증가부분수열 {
	
	static int N;
	static int[] arr, lis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr = new int[N];
			lis = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(search_lis());
			System.out.println(sb);
		}
	}
	
	public static int search_lis() {
		int index = 0;
		lis[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			if(lis[index] < arr[i]) {
				index++;
				lis[index] = arr[i];
			}
			else {
				lis[search_index(0, index, arr[i])] = arr[i];
			}
			
		}
		return index +1;
	}
	
	public static int search_index(int start, int end, int value) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(value > lis[mid]) start = mid+1;
			else end = mid;
		}
		return end;
	}

}
