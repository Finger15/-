package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_3109_빵집 {
	
	static char[][] map;
	static boolean[][] check;
	static int row, col;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		check = new boolean[row][col];
		map = new char[row][col];
		
		
		for(int i=0; i<row; i++) {
			String str = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		
		for(int i=0; i<row; i++) {
			if(isAvailable(i, 0)) ans++;
		}
		System.out.println(ans);
		
	}

	private static boolean isAvailable(int x, int y) {
		for(int i=0; i<3; i++) {
			int tmpx = x+dx[i];	// 오위, 오, 오아
			int tmpy = y+dy[i];
			
			if(tmpx >=0 && tmpy >= 0 && tmpx < row && tmpy <col) {
				if(check[tmpx][tmpy] == false && map[tmpx][tmpy] =='.') {	// 가야할 곳이 '.'이고 방문하지 않으면
					check[tmpx][tmpy] = true;	// 방문처리하고
					if(tmpy == col-1)  return true;	// 빵집에 도착했다면 
					if(isAvailable(tmpx, tmpy)) return true; // 조건체크
				}
			}
			
		}
		
		return false;
	}
	
}
