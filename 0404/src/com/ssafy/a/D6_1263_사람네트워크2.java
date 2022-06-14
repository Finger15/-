package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D6_1263_사람네트워크2 {
	
	static final int INF = 9999999;
	static int N,arr[][];
	static int[] CC;

	public static void main(String[] args) throws IOException {

	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int T = Integer.parseInt(br.readLine());
	 
	 	for(int tc=1; tc<=T; tc++) {
	 		 StringBuilder sb = new StringBuilder();
	 		 sb.append("#").append(tc).append(" ");
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 arr = new int[N][N];
			 CC = new int[N];
			 
			 for(int i=0; i<N; i++) {
				 for(int j=0; j<N; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
					 if(i != j && arr[i][j]==0) {
							arr[i][j]=INF;
						}
				 }
			 }
		 
	     
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue; 
					for(int j=0; j<N; ++j) {
						if(i==j || k==j) continue; 
						if(arr[i][j] > arr[i][k]+arr[k][j]) {
							arr[i][j] = arr[i][k]+arr[k][j];
						}
					}
				}
				
			}
			
			for(int i=0; i<N; i++) {
				 for(int j=0; j<N; j++) {
					 CC[i]+=arr[i][j];
				 }
			 }
			
			Arrays.sort(CC);
			sb.append(CC[0]);
			System.out.println(sb);
		}
	}
}
