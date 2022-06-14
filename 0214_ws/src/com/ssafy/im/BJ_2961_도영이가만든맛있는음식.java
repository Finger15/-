package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2961_도영이가만든맛있는음식 {
	
	static int[][] arr;
	static int min_score;
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		min_score = Integer.MAX_VALUE;
		search(0);
		System.out.println(min_score);
		
	}
	
	public static void search(int cnt) {

		if(cnt==arr.length) {
			
			int sour = 1;
			int salty = 0;
			int tmp = 0;
			
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					tmp++;
					sour *= arr[i][0];
					salty += arr[i][1];
				}
				
			}
			if(tmp == 0) return;
			
			if(min_score > Math.abs(sour-salty)){
				min_score = Math.abs(sour-salty);
			}
			return;
		}	
		visited[cnt] = true;
		search(cnt +1);
		visited[cnt] = false;
		search(cnt +1);
	}
}



