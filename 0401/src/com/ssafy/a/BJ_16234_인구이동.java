package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_16234_인구이동 {
	
	static int N, L, R, cnt;
	static int [][] arr, map;
	static boolean [][] visited, checked;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		arr = new int[N][N];
		map = new int[N][N];
		visited = new boolean[N][N];
		checked = new boolean[N][N];
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt2=0;
		
		while(true) {
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						map[i][j] = 10*i+j+1;
						search(i,j,10*i+j+1);
					}
				}
			}
			
			if(cnt == 0) {
				break;
			}
			
			cnt2++;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!checked[i][j]) {
						update(10*i+j+1);
					}
				}
			}
			
			cnt = 0;
			
			for(boolean[]a : visited) {
				Arrays.fill(a, false);	
			}
			
			for(boolean[]a : checked) {
				Arrays.fill(a, false);	
			}
			
			for(int [] a : map) {
				Arrays.fill(a, 0);
			}	
					
		}
		
		System.out.print(cnt2);
		
	}
	
	static void search(int x , int y, int k) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny >=0 && nx<N && ny <N && !visited[nx][ny]) {
				if(Math.abs(arr[x][y] - arr[nx][ny]) >= L && Math.abs(arr[x][y] - arr[nx][ny]) <= R) {
					cnt++;
					map[nx][ny] = k;
					search(nx, ny, k);
				}
			}
		}
	}
	
	static void update(int k) {
		int sum = 0;
		int num = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == k) {
					checked[i][j] = true;
					num++;
					sum += arr[i][j];
				}
			}
		}
		
		sum /= num;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] ==k ) {
					arr[i][j] = sum;
				}
			}
		}
	}

}
