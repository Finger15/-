package com.ssafy.im;

import java.util.*;
import java.io.*;

public class SW_4012_요리사 {
	static int min_value;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			boolean[] visited = new boolean[N];
		
			min_value = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(arr, visited, 0,N,N/2);
			sb.append(min_value);
			System.out.println(sb);
			
		}
	}
	
	static void combination(int[][] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
        	int sum1 =0;
        	int sum2 =0;
        	
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					for(int j=i+1; j<n;j++) {
						if(visited[j]) {
							sum1 += arr[i][j];
							sum1 += arr[j][i];
						}
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					for(int j=i+1; j<n;j++) {
						if(!visited[j]) {
							sum2 += arr[i][j];
							sum2 += arr[j][i];
						}
					}
				}
			}
			
			min_value = Math.min(min_value, Math.abs(sum1-sum2));
			
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}
