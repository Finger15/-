package com.ssafy.a;
import java.util.*;
import java.io.*;

public class BJ_1600_말이되고픈원숭이 { 
	
	static int row, col,k;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static boolean [][][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] hdx = {-2,-2,-1,-1,1,1,2,2};
	static int[] hdy = {-1,1,-2,2,-2,2,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		visited = new boolean[row][col][k+1];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		 min = moving(0, 0);
	        
	     if(min == Integer.MAX_VALUE) System.out.println("-1");
	     else System.out.println(min);
		
	}
	
	public static int moving(int x, int y) {
		Queue<m> q = new LinkedList<>();
		q.offer(new m(x,y,0,k));
		visited[x][y][k] = true;
		
		while(!q.isEmpty()) {
			m current = q.poll();
			if(current.x == row-1 && current.y == col-1) return current.count;
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx >=0 && ny >=0 && nx< row && ny < col && !visited[nx][ny][current.k] && arr[nx][ny]==0) {
					visited[nx][ny][current.k] = true;
					q.offer(new m(nx,ny, current.count +1, current.k));
				}
			
			}
			
			   if(current.k > 0) {
	                for(int i = 0; i < 8; i++) {
	                    int nx = current.x + hdx[i];
	                    int ny = current.y + hdy[i];
	                    if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny][current.k - 1] && arr[nx][ny] == 0) {
	                        visited[nx][ny][current.k - 1] = true;
	                        q.offer(new m(nx, ny, current.count + 1, current.k - 1));
	                    }
	                }
			   }	   
		}
		
		return min;
		
	}

	public static class m {
        int x;
        int y;
        int count;
        int k;
        
        public m(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}
