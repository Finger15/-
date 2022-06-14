package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1987_알파벳 {
	
		static int R, C;
		static int[][] map;
		static boolean[] check = new boolean[26];
		static int[] dx = { -1, 1, 0, 0 };
		static int[] dy = { 0, 0, -1, 1 };
		static int cnt = 0;

		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j) - 'A';
				}
			}

			dfs(0, 0, 0);
				

				System.out.println(cnt);
			}

		public static void dfs(int x, int y, int count) {
			
			if (check[map[x][y]]) { 
				cnt = Math.max(cnt, count); 
				return;
				
			} else {
				
				check[map[x][y]] = true;
				
				for (int i = 0; i < 4; i++) {
					int cx = x + dx[i];
					int cy = y + dy[i];

					if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
							dfs(cx, cy, count + 1);
					}

				}

				check[map[x][y]] = false;

			}
		}

	}
	



