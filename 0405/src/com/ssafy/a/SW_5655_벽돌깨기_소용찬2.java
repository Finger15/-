package com.ssafy.a;

import java.util.*;
import java.io.*;

public class SW_5655_벽돌깨기_소용찬2 {
	
	static int H, W, N, min;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<= T; tc++) {
				
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			 N = Integer.parseInt(st.nextToken());
			 W = Integer.parseInt(st.nextToken());
			 H = Integer.parseInt(st.nextToken());
	
			int[][] map = new int[H][W];
	
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0,map);
			sb.append(min);
			System.out.println(sb);
			
		}
	}

	private static boolean go(int count, int[][] map) {
		int result = getRemain(map);
		
		if(result ==0) {
			min = 0;
			return true;
		}
		
		if(count == N) {
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		
		for(int c= 0; c<W; c++) {
			int r =0;
			while(r<H && map[r][c] == 0) ++r;
			
			if(r==H) continue;
			
			copy(map, newMap);
			boom(newMap,r,c);
			falling(newMap);
			
			if(go(count+1, newMap)) return true;
		}
		return false;
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		if(map[r][c] > 1) {
			q.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = p.r, nc =p.c;
				
				for(int k=1; k<p.cnt; k++) {
					nr += dx[d];
					nc += dy[d];
					
					if(nr>=0 && nc >=0 && nr<H && nc<W && map[nr][nc] > 0) {
						if(map[nr][nc]>1) {
							q.offer(new Point(nr,nc, map[nr][nc]));
						}
						map[nr][nc]=0;
					}
				}
			}
		}
		
	}
	
	
	static int getRemain(int [][] map) {	// 남은 벽돌 수 리턴
		int cnt=0;
		
		for (int r = 0; r < H; r++) {
			for(int c =0; c<W; c++) {
				if(map[r][c] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void copy(int[][] map, int[][] newMap) {
		
		for(int i=0; i<H; i++){
			for(int j=0; j<W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
	}

	static void falling(int[][] map) {	// 벽돌 자유낙하
		for(int j=0; j<W; j++) {
			int[] tmp = new int[H];
			
			for(int i=0; i<H; i++) {
				tmp[i] = map[i][j];
			}
			
			for(int i=H-1; i>0; i--) {
				for(int k = i-1; k>=0; k--) {
					if(tmp[i]== 0 &&  tmp[k] !=0) {
						int tmp2 = tmp[k];
						tmp[k] = tmp[i];
						tmp[i] = tmp2;
					}
				}
			}
			
			for(int i=0; i<H; i++) {
				map[i][j] = tmp[i];
			}
			
		}

	}
	
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
