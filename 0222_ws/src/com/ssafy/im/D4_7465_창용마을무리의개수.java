package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_7465_창용마을무리의개수 {
	
	static int N;
	static int[] parents;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int tc =1; tc<=T; tc++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 StringBuffer sb = new StringBuffer();
			 sb.append("#").append(tc).append(" ");
			 
			 int N = Integer.parseInt(st.nextToken());
			 int M = Integer.parseInt(st.nextToken());
			 
			 parents = new int[N+1];
			 
			 for(int i=1; i<=N; i++) {
					parents[i] = i;
				}
			 
			 for(int i=0;i<M; i++) {
				 st = new StringTokenizer(br.readLine());
				 int a = Integer.parseInt(st.nextToken());
				 int b = Integer.parseInt(st.nextToken());
				 union(a, b);
			 }
			 
			 for(int i=1; i<=N; i++) {		// 부모로 단일화
				 parents[i] = findSet(i);
			 }
			 
			 boolean[]check = new boolean [N+1];	
			 int tmp=0,cnt =0;
			 
			 
			 for(int i=1; i<=N; i++) {		// 부모가 다른거 찾기
				 if(tmp != parents[i]) {
					 if(!check[parents[i]]){
						 check[parents[i]] = true;
						 cnt++;
					 } 
				 }
			 }
			 
			 sb.append(cnt);
			 System.out.println(sb);
			 
		 }
	}

	
	public static int findSet(int a) {		// 부모 찾기
		if(a==parents[a]) return a;
		
		return  parents[a] = findSet(parents[a]); // path compression
		 
	}
	
	public static void union(int a, int b) {		// 집합 합치기
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}
}
