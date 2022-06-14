package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1759_암호만들기 {
	
	static int N, r;
	static char[] input;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
	    input = new char[N];
	    visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(input);
		search(0,0);

	}
	
	public static void search(int cnt, int start) {
		
		if(cnt == r) {
			int tmp_cnt = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int i =0;i<N; i++) {
				if(visited[i]) {
					sb.append(input[i]);
					if(input[i] == 'a' || input[i] == 'i' || input[i] == 'e' || input[i] == 'u' || input[i] == 'o') {
						tmp_cnt++;
					}
				}
			}
			if(tmp_cnt >=1 && r-tmp_cnt >=2) System.out.println(sb);
			
		}
		
		for(int i=start; i<N; i++) {
			
			visited[i] = true;
			search(cnt+1, i+1);
			visited[i] = false;
		}
	}

}
