package com.ssafy.a;

import java.util.*;
import java.io.*;

public class SW_1953_탈주범검거_소용찬 {
	
	private static int n, m, r, c, l, count; 
	private static int[][] map; 
	private static boolean[][] visit;
	private static int[] dx = {-1, 0, 1, 0}; 
	private static int[] dy = {0, 1, 0, -1}; 
	private static boolean[][] status = { {true, true, true, true}, {true, false, true, false}, 
			{false, true, false, true}, {true, true, false, false}, {false, true, true, false}, 
			{false, false, true, true}, {true, false, false, true} };

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); 
		
		for (int t = 1; t <= T; t++) { 
			st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken()); 
			m = Integer.parseInt(st.nextToken()); 
			r = Integer.parseInt(st.nextToken()); 
			c = Integer.parseInt(st.nextToken()); 
			l = Integer.parseInt(st.nextToken()); 
			map = new int[n][m]; 
			visit = new boolean[n][m]; count = 0; 
			
			for (int i = 0; i < n; i++) { 
				st = new StringTokenizer(br.readLine()); 
				
				for (int j = 0; j < m; j++) { 
					map[i][j] = Integer.parseInt(st.nextToken()); 
					} 
				} 
			
			solution(); 
			
			System.out.println("#" + t + " " + count); }
	
	}


	private static void solution() {
		Queue<Index> q = new LinkedList<>();
		q.add(new Index(r,c));
		visit[r][c]= true;
		
		int nr, nc;
		
		while(l-- > 0) {
			int len = q.size();
			
			for(int t=0; t<len; t++) {
				Index target = q.poll();
				count++;
				
				for(int i=0; i<4; i++) {
					nr = target.x + dx[i];
					nc = target.y + dy[i];
					
					int type = map[target.x][target.y];
					
					if(status[type-1][i] && isValid(nr, nc)) {
						if(map[nr][nc] !=0 && !visit[nr][nc]) {
							int nType = map[nr][nc];
							
							if(status[nType-1][(i+2) % 4]) {
								q.add(new Index(nr,nc));
								visit[nr][nc] = true;
							}
						}
					}
				}
			}
		}	
	}
	
	private static boolean isValid(int x, int y) { 
		if (x < 0 || y < 0 || x >= n || y >= m) return false; 
		return true; 
			
	}

	static class Index {
		int x;
		int y;
		
		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}


		
