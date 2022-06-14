package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_4485_녹색옷입은애가젤다지 {
	
	static int[][] map;
	static int[][] result;
	static int N; 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			result = new int [N][N];
			StringBuilder sb = new StringBuilder();
		
			if(N == 0) {
				break;
			}
			
			cnt++;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE;
				}
			}	
			result[0][0] = map[0][0];
			
			search();
			
			sb.append("Problem ").append(cnt).append(": ").append(result[N-1][N-1]);
			System.out.println(sb);
		}
		
	}
	
	static private class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void search() {
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0));
		
		while (!queue.isEmpty()) {
			int nx, ny;
			Node pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if (!isRange(nx, ny))
					continue;
				
				if (result[nx][ny] <= result[x][y] + map[nx][ny])
					continue;
				
				result[nx][ny] = result[x][y] + map[nx][ny];
				queue.add(new Node(nx, ny));
			}
		}
	}

	private static boolean isRange(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N ? false : true;
	}

}
