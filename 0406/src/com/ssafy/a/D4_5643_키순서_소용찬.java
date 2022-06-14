package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D4_5643_키순서_소용찬 {
	
	static int N, M, sum;
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			num = new int[N+1];
			a = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++) {
				a[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				a[from].add(to);
			}
			
			for(int i=1; i<=N; i++) {
				sum=0;
				visited = new boolean[N+1];
				visited[i] = true;
				dfs(i);
				num[i] +=sum;
			}
			
			int result = 0;
			for(int i=1; i<=N; i++) {
				if(num[i]==N) {
					result++;
				}
			}
		
			sb.append(result);
			System.out.println(sb);
		
		}

	}

	private static void dfs(int k) {
		sum++;
		for(int i=0; i<a[k].size(); i++) {
			if(visited[a[k].get(i)]) {
				continue;
			}
			visited[a[k].get(i)] = true;
			num[a[k].get(i)]++;
			dfs(a[k].get(i));
		}
		
	}
}
