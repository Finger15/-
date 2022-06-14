package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_1238_Contact {
	
	static final int vertex = 101;
	static int N, V;
	static ArrayList<Integer> list;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1; tc<=10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int[][] adjMatrix = new int[vertex][vertex];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i <= N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjMatrix[from][to] = 1;
			}
			bfs(adjMatrix, V);
			list.sort(null);
			sb.append(list.get(list.size() - 1));
			System.out.println(sb);
		}
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[vertex];
		
		q.offer(start);
		visited[start] = true;
		int size = 0;
		
		while(!q.isEmpty()) {
			
			size = q.size();
			list.clear();
			
			while( size >0) {
				int current = q.poll();
				list.add(current);
				for(int j =0; j<vertex; j++) {
					if(!visited[j] && adjMatrix[current][j] > 0) {
						 q.offer(j);
						 visited[j] = true;
					 }
				}
				size--;
			}
				
		}

	}
}
