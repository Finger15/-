package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_10026_적록색약 {
	
	static int N, minx, miny;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static char[][] map1, map2;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];		// 일반인
		map2 = new char[N][N];		// 색약
		visited = new boolean[N][N];	// 방문체크용
	
		minx = miny = 0;
		int cnt1 = 0;
		int cnt2 =0;
		
		for(int i=0;i<N; i++) {		// 입력데이터 맵핑
			String str = br.readLine();
			map1[i]= str.toCharArray();
			for(int j=0; j<N; j++) {
				if(str.charAt(j) == 'G') {
					map2[i][j] = 'R';
					continue;
				}
				
				map2[i][j] = str.charAt(j);
			}
		}
		
		
		while(!istrue()) {
			dfs1(minx, miny);
			whereis();
			cnt1++;	
		}	
		
		for(boolean[]i : visited) {		// 색약의 경우 탐색하기 전
			Arrays.fill(i, false);		// 방문배열과 minx,miny 초기화
		}
		
		minx = miny = 0;
		
		while(!istrue()) {
			dfs2(minx, miny);
			whereis();
			cnt2++;
		}
		
		sb.append(cnt1).append(" ").append(cnt2);
		System.out.println(sb);
		
	}

	public static void dfs1(int row, int col) {		// 같은거만 다 탐색(일반인)
		visited[row][col] = true;
		
		for(int i=0; i<4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if(nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny] && map1[nx][ny] == map1[row][col]) {
				dfs1(nx, ny);
			}
		}
	}
	
	public static void dfs2(int row, int col) {		// 같은거만 다 탐색(적녹색약)
		visited[row][col] = true;
		
		for(int i=0; i<4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if(nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny] && map2[nx][ny] == map2[row][col]) {
				dfs2(nx, ny);
			}
		}
	}
	
	public static boolean istrue() {		// 모두 탐색 되었는지?
		
		for(boolean[] i : visited) {
			for(boolean j : i) {
				if(!j) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void whereis() {			// 다음 탐색지점 찾기
		
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(!visited[i][j]) {
					minx = i;
					miny = j;
				}
			}
		}
	}
}
