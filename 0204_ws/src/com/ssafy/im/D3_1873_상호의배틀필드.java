package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		char up = '^';
		char down = 'v';
		char left = '<';
		char right = '>';
		char block = '*';
	    char water = '-';
	    char iron = '#';
	    char land = '.';
		
		System.setIn(new FileInputStream("input_D3_1873_상호의배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
	            int H = Integer.parseInt(st.nextToken());
	            int W = Integer.parseInt(st.nextToken());
	            char[][] map = new char[H][W];

	            int row = 0;  
	            int col = 0;  
	          
	            int[] dr = {-1, 1, 0, 0};
	            int[] dc = {0, 0, -1, 1};
	            int dir = 0;

	           
	            for (int i = 0; i < H; i++) {
	                String str = br.readLine();
	                for (int j = 0; j < W; j++) {
	                    map[i][j] = str.charAt(j);
	                    if (map[i][j] == up || map[i][j] == down || map[i][j] == left || map[i][j] == right) {
	                        row = i;
	                        col = j;
	                    }
	                    if (map[i][j] == up) {
	                        dir = 0;
	                    } else if (map[i][j] == down) {
	                        dir = 1;
	                    } else if (map[i][j] == left) {
	                        dir = 2;
	                    } else if (map[i][j] == right) {
	                        dir = 3;
	                    }
	                }
	            }

	            int N = Integer.parseInt(br.readLine());
	            String st1 = br.readLine();

	            for (int i = 0; i < st1.length(); i++) {
	             
	                if (st1.charAt(i) == 'S') {
	                   
	                    int nr = row + dr[dir];
	                    int nc = col + dc[dir];
	                   
	                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
	                        continue;
	                    }
	                   
	                    if (dir == 0 || dir == 1) {
	                        while (nr >= 0 && nr < H) {
	                            if (map[nr][nc] == block) {
	                                map[nr][nc] = land;
	                                break;
	                            } else if (map[nr][nc] == iron) {
	                                break;
	                            }
	                            nr += dr[dir];
	                        }
	                    } else if (dir == 2 || dir == 3) { 
	                        while (nc >= 0 && nc < W) {
	                            if (map[nr][nc] == block) {
	                                map[nr][nc] = land;
	                                break;
	                            } else if (map[nr][nc] == iron) {
	                                break;
	                            }
	                            nc += dc[dir];
	                        }
	                    }
	                } else {   
	                    if (st1.charAt(i) == 'U') {
	                        dir = 0;
	                        map[row][col] = up;
	                    } else if (st1.charAt(i) == 'D') {
	                        dir = 1;
	                        map[row][col] = down;
	                    } else if (st1.charAt(i) == 'L') {
	                        dir = 2;
	                        map[row][col] = left;
	                    } else {
	                        dir = 3;
	                        map[row][col] = right;
	                    }
	                    int nr = row + dr[dir];
	                    int nc = col + dc[dir];
	                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
	                        continue;
	                    }
	                    if (map[nr][nc] == land) {
	                        map[nr][nc] = map[row][col];
	                        map[row][col] = land;
	                        row = nr;
	                        col = nc;
	                    }
	                }
	            }

	            System.out.print("#" + tc + " ");
	            for (int i = 0; i < H; i++) {
	                for (int j = 0; j < W; j++) {
	                    System.out.print(map[i][j]);
	                }
	                System.out.println();
	            }
			
			
		}
	}
	
}
