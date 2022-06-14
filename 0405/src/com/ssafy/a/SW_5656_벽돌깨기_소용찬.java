package com.ssafy.a;

import java.util.*;
import java.io.*;

public class SW_5656_벽돌깨기_소용찬 {
	static int[] dr = {-1, 1, 0,0};
	static int[] dc = {0,0,-1,1};
	static int N,W,H,min;
	
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		
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
	
	private static boolean go(int count, int[][] map) { // 중복순열을 이용하여 구슬을 던지기, 벽돌이 다 부서졌다면 true 아니면 false
		int result = getRemain(map);
		
		if(result == 0) {  // 남은 벽돌이 없는 경우
			min= 0;
			return true;
		}
		
		if(count==N) {	   // 구슬을 모두 던졌을 경우
			min = Math.min(min, result);
			return false;
		}
		
		
		int[][] newMap = new int[H][W];
		// 0열부터 W-1 열까지 구슬 던져보기
			for (int c = 0; c < W; c++) {
				
				// 구슬에 맞는 벽돌 찾기
				int r = 0;
				while(r<H && map[r][c] ==0) ++r;
				
				// 해당 열은 벽돌이 없음
				if(r==H) continue;
				
				// 배열의 상태를 백업
				copy(map, newMap);
				
				boom(newMap,r,c);	// 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
				
				falling(newMap);	// 벽돌 자유나하
				
				if(go(count+1,newMap)) return true;	// 다음 구슬 던지기
			}
			return false;
			
		}
	
	
	private static void boom(int[][] map, int r, int c) { //d r,c 위치에서 주변의 가능한 모든 벽돌도 함께 제거
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c] > 1) { // 벽돌 크기가 2이상이면
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0;  // 자신은 0으로 
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr =p.r , nc = p.c;
				
				for(int k=1; k<p.cnt ; k++) {	//  벽돌의 크기 -1 만큼 반복
					nr += dr[d];
					nc += dc[d];
					
					if(nr>=0 && nc >=0 && nr<H && nc<W && map[nr][nc] > 0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
					
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
	
	static void copy (int [][] map , int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for(int c =0; c<W; c++) {
				newMap[r][c] = map[r][c];
			}

		}
	}

}
