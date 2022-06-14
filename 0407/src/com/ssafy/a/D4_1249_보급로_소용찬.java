package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D4_1249_보급로_소용찬 {
	
	static int N =0, INF =  Integer.MAX_VALUE;
	static int map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					map[i][j] = ch[j] -'0';
				}
			}
			
			System.out.println("#" + tc +" " +dijkstra(0,0));
		}
		
	}

	private static int dijkstra(int starR, int startC) {
		
		boolean[][] visited = new boolean[N][N];
		int [][] minTime = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare (int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
		});
	
		
		minTime[starR][startC] = 0;
		pq.offer(new int[] {starR,startC,minTime[starR][startC]});
		
		int r,c,nr,nc,current[];
		int minCost;
		
		while(true) {
			current = pq.poll();	// pq안의 정점  출발지에서 자신으로의 비용이 최소인 정점의 정보
			r = current[0];
			c = current[1];
			minCost = current[2];
			
			if(visited[r][c]) continue;
			
			visited[r][c] = true;
			
			if(r== N-1 && c==N-1) return minCost; // 도착지라면 끝내기
			
			// 현 정점의 인접정점 들여다보며 최소비용 갱신
			
			for(int d=0; d<4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N &&
						//!visited[nr[nc &&
					minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pq.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
		}
		
	}

}
