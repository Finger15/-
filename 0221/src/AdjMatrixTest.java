
/*
 7
 8
 0 1
 0 2
 1 3
 1 4
 2 4
 3 5
 4 5
 5 6
 */

import java.util.*;
import java.io.*;

// 무향 그래프
public class AdjMatrixTest {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		
		int[][] adjMatrix = new int [N][N];		// 정점수 크키로 생성 정방행렬
		
		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
			
		}
		
//		for(int[]is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
//		bfs(adjMatrix, 0);
		dfs(adjMatrix, new boolean[N],0);
	}
	public static void  bfs(int[][] adjMatrix, int start) {
		 Queue<Integer> q = new LinkedList<Integer>();
		 boolean[] visited = new boolean[N];
		 
		 q.offer(start);
		 visited[start] = true;
		 
		 while(!q.isEmpty()) {
			 int current = q.poll();
			 System.out.println(current);
			 
			 // current 정점의 인접정점 처리(단, 방문하지 않은 정접만)
			 
			 for (int j=0; j<N; j++) {
				 if(!visited[j] && adjMatrix[current][j] > 0) {
					 q.offer(j);
					 visited[j] = true;
				 }
			 }
		 }
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 정접만)
		
		 for (int j=0; j<N; j++) {
			 if(!visited[j] 
					 && adjMatrix[current][j] > 0) {
				dfs(adjMatrix, visited, j);
			 }
		 }
	}

}
