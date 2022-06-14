package com.ssafy.im;

import java.util.*;
import java.io.*;


class CCTV{
	int num;
	int row;
	int col;
	
	CCTV(int num, int x, int y){
		this.num = num;
		this.row = x;
		this.col = y;
	}
}

public class BJ_15683_감시 {
	
	static int[][] map;
	static int[][] tmp_map;
	static int cnt = Integer.MAX_VALUE;
	static int[] dx = {-1,0,1,0};  // 상 우 하 좌
	static int[] dy = {0,1,0,-1};
	static ArrayList<CCTV> clist;
	static int[] result;
	static int row, col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		clist = new ArrayList<>();
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=1 && map[i][j] <= 5) {
					clist.add(new CCTV(map[i][j], i, j));
				}
			}
		}
		
		result = new int[clist.size()];
		
		gaCha(clist.size(), 0);
		
		System.out.println(cnt);
		
	}
	
	public static void gaCha(int n, int r) {	// 순열로 각각 경우 판별
		if(r == n) {
			tmp_map = new int[row][col];
			
			for(int i=0; i<map.length; i++) {
				System.arraycopy(map[i], 0, tmp_map[i], 0, map[i].length);
			}
			
			for(int i =0; i<clist.size(); i++) {
				setDirection(clist.get(i), result[i]);
			}
			
			getCnt();
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			result[r] = i;
			gaCha(n, r+1);
		}
	}

	private static void getCnt() {
		int tmp_cnt =0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(tmp_map[i][j] ==0) tmp_cnt++;
			}
		}
		
		cnt = Math.min(cnt, tmp_cnt);
		
	}

	private static void setDirection(CCTV cctv, int n) {	// 방향설정해주기
		int number = cctv.num;
		
		if(number ==1) { 			// 1번 cctv
			if(n==0) search(cctv,0);
			else if(n==1) search(cctv,1);
			else if(n==2) search(cctv,2);
			else if(n==3) search(cctv,3);
		}
		
		else if(number == 2) {		// 2번 cctv
			if(n == 0 || n== 2) {
				search(cctv, 0);
				search(cctv, 2);
			}
			else {
				search(cctv, 1);
				search(cctv, 3);
			}
		}
		
		else if(number == 3) {		// 3번 cctv
			if(n==0) {
				search(cctv, 0);
				search(cctv, 1);
			}
			else if(n==1) {
				search(cctv, 1);
				search(cctv, 2);
			}
			else if(n==2) {
				search(cctv, 2);
				search(cctv, 3);
			}
			else if(n==3) {
				search(cctv, 0);
				search(cctv, 3);
			}
		}
		else if(number == 4) {		// 4번 cctv
			if(n==0) {
				search(cctv, 0);
				search(cctv, 1);
				search(cctv, 3);
			}
			else if(n==1) {
				search(cctv, 0);
				search(cctv, 1);
				search(cctv, 2);
			}
			else if(n==2) {
				search(cctv, 1);
				search(cctv, 2);
				search(cctv, 3);
			}
			else if(n==3) {
				search(cctv, 0);
				search(cctv, 2);
				search(cctv, 3);
			}
		}
		else if(number == 5) {
			search(cctv, 0);
			search(cctv, 1);
			search(cctv, 2);
			search(cctv, 3);
		}
	}

	private static void search(CCTV cctv, int n) {
		Queue<CCTV> q = new LinkedList<>();
		boolean[][] visited = new boolean[row][col];
		
		q.add(cctv);
		visited[cctv.row][cctv.col] = true;
		
		while(!q.isEmpty()) {
			int tmprow = q.peek().row + dx[n];
			int tmpcol = q.poll().col + dy[n];
			
			if(tmprow < 0 || tmpcol <0 || tmprow >=row || tmpcol >= col || tmp_map[tmprow][tmpcol] == 6) break;
			
			if(tmp_map[tmprow][tmpcol] == 0) {
				tmp_map[tmprow][tmpcol] = -1;
				q.add(new CCTV(cctv.num, tmprow, tmpcol));
			}
			else q.add(new CCTV(cctv.num, tmprow, tmpcol));
		}
		
	}
}
