package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_2636_치즈 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] arr;
	static boolean[][] visited;
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		visited = new boolean[row][col];
		int init = 0;
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					init++;
				}
			}
		}
		
		int sec = 0; 	// 시간초
		int cnt = 0;
		
		
		while(true) {
			cnt = 0;
			sec++;
			
			search0(0,0);
			
			for(boolean a[] : visited) {
				Arrays.fill(a, false);
			}
			
			search1(0,0);
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(arr[i][j]== 2) {
						arr[i][j]=0;
					} else if(arr[i][j] == 1) {
						cnt++;
					}
				}
			}
			
			for(boolean a[] : visited) {
				Arrays.fill(a, false);
			}
			
			if(cnt ==0) break;
			init = cnt;
			
		}
		
		sb.append(sec).append("\n").append(init);
		System.out.println(sb);
		
	}
	
	public static void search0(int p1, int p2) {
		visited[p1][p2] = true;
		
		for(int i=0; i<4; i++) {
			int tx = p2 + dx[i];
			int ty = p1 + dy[i];
			
			if(tx>=0 && ty>=0 && tx<col && ty <row && arr[ty][tx] == 0 && !visited[ty][tx]) {
				search0(ty, tx);
			} else if(tx>=0 && ty>=0 && tx<col && ty <row && arr[ty][tx] == 1 && !visited[ty][tx]) {
				arr[p1][p2] = 2;
			}
		}
	}
	
	public static void search1(int p1, int p2) {
		visited[p1][p2] = true;
		
		for(int i=0; i<4; i++) {
			int tx = p2 + dx[i];
			int ty = p1 + dy[i];
			
			
				if(tx>=0 && ty>=0 && tx<col && ty <row  && arr[ty][tx] == 2) {
					if(arr[p1][p2]==2) {
						continue;
					}
					arr[p1][p2] = 0;
					search1(ty,tx);
					
				} else if(tx>=0 && ty>=0 && tx<col && ty <row && !visited[ty][tx]) {
					search1(ty,tx);
				}
			 
		}
	}
	
}
