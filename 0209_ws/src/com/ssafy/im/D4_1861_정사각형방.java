package com.ssafy.im;

import java.io.*;
import java.util.*;

public class D4_1861_정사각형방 {
	static int[][] arr;
	static boolean check[][];
	static int number,N;

	public static void main(String[] args) throws NumberFormatException, IOException  {
//		System.setIn(new FileInputStream("input_D4_1861_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			 N = Integer.parseInt(br.readLine());
			 arr = new int[N][N];
			 check = new boolean[N][N];
			 int min_number = N*N+1;
			 int max_cnt = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int cnt = 0;
					int plus = howmanyMove(i, j, 1);
					check[i][j] = false;
					int minus = howmanyMove(i, j, -1);
					
					cnt = plus+minus -1;
					if(max_cnt == cnt && min_number > arr[i][j]) {
						min_number = number;
					}
					else if (max_cnt < cnt) {
						min_number = number;
						max_cnt = cnt;
					}
				}
			}
			sb.append(min_number).append(" ").append(max_cnt);
			System.out.println(sb);
		}

	}
	
	public static int howmanyMove(int nowrow, int nowcol, int mod) {
		int dr[] = {-1,1,0,0};		// 상하좌우 이동
		int dc[] = {0,0,-1,1};
		
		int tmp_cnt = 1;
		
		while(!(check[nowrow][nowcol])) {		// 가지 않은 곳을 탐색
			check[nowrow][nowcol] = true;
			
			for(int i =0; i<4; i++) {
				int tmp_row = dr[i]+nowrow;		// 나아가야할 곳의 인덱스
				int tmp_col = dc[i]+nowcol;
				
				if(tmp_row >=0 && tmp_row<N && tmp_col >=0 && tmp_col<N && arr[nowrow][nowcol]+mod==arr[tmp_row][tmp_col]) {
					tmp_cnt++;		// 배열의 인덱스 범위 안에서 탐색조건 만족시
					nowrow = tmp_row;
					nowcol = tmp_col;
					break;
				}
			}
		}
		if(mod == -1) {
			number = arr[nowrow][nowcol];		// 시작점 기록;
		}
		return tmp_cnt;
	}
	

}
