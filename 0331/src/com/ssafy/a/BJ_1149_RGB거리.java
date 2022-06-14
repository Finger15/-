package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_1149_RGB거리 {
	static int N;
	static int[][] arr;
	static int[][] arr2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		arr2 = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr2[0][0] = arr[0][0];
		arr2[0][1] = arr[0][1];
		arr2[0][2] = arr[0][2];
		
		System.out.println(Math.min(search(N-1,0), Math.min(search(N-1,1), search(N-1,2))));

	}
	
	static int search(int N, int color) {
			
			if(arr2[N][color] == 0) {
				
				if(color == 0) {
					arr2[N][0] = Math.min(search(N - 1, 1), search(N - 1, 2)) + arr[N][0];
				}
				else if(color == 1) {
					arr2[N][1] = Math.min(search(N - 1, 0), search(N - 1, 2)) + arr[N][1];
				}
				else {
					arr2[N][2] = Math.min(search(N - 1, 0), search(N - 1, 1)) + arr[N][2];
				}
				
			}
			
			return arr2[N][color];
		}
}
