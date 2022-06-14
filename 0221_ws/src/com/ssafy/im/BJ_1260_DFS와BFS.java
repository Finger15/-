package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1260_DFS와BFS {
	
	static int N, M, V;
	static StringBuilder sb1, sb2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		sb1 = new StringBuilder();
		dfs(adjMatrix, new boolean[N+1], V);
		sb1.setLength(sb1.length() -1);
		
		sb2 = new StringBuilder();
		bfs(adjMatrix, V);
		sb2.setLength(sb2.length() -1);
		
		System.out.println(sb1);
		System.out.println(sb2);
	}
	
	public static void bfs(int [][] adjMatrix, int start) {
		 Queue<Integer> q = new LinkedList<Integer>();
		 boolean[] visited = new boolean[N+1];
		 
		 q.offer(start);
		 visited[start] = true;
		 
		 while(!q.isEmpty()) {
			 int current = q.poll();
			 sb2.append(current).append(" ");
			 
			 for (int j=0; j<N+1; j++) {
				 if(!visited[j] && adjMatrix[current][j] > 0) {
					 q.offer(j);
					 visited[j] = true;
				 }
			 }
		 }
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		sb1.append(current).append(" ");

		 for (int j=1; j<=N; j++) {
			 if(!visited[j] && adjMatrix[current][j] > 0) {
				dfs(adjMatrix, visited, j);
			 }
		 }
	}

}
