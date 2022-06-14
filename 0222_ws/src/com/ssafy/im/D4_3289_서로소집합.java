package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_3289_서로소집합 {
	
	static int n;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			
			for(int i=0; i<n; i++) {
				parents[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int mod = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(mod) {
				case 0:
					union(a,b);
					break;
				case 1:
					if(findSet(a) == findSet(b)) {
						sb.append(1);
						break;
					}
					else {
						sb.append(0);
						break;
					}
					
				}
			}
			System.out.println(sb);
		}
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		
		return  parents[a] = findSet(parents[a]); // path compression
		 
	}
	
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}

}
