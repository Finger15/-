package com.ssafy.im;

import java.util.*;
import java.io.*;

/**
 * 
 * @author 소용찬
 *
 */

public class BJ_16236_아기상어 {
	
	static class fish  {
		int x;		// 행
		int y;		// 열
		int size;	// 크기
		int eatCnt;	// 먹이를 먹은 횟수
		int dis;	// 이동한 횟수
		
		public fish(int x, int y, int size, int eatcnt, int dis) {
			
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatCnt = eatcnt;
			this.dis = dis;
		}
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	     BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	     int N = Integer.parseInt(br.readLine());
	     int[][] map = new int[N][N];
	     List<fish> fishes = new ArrayList<>();
	     int result = 0;
	     int[] dx = {-1,1,0,0,};
	     int[] dy = {0,0,-1,1};
	     
	     fish shark = null;		// 아기 상어
	     
	     for(int i=0; i<N; i++) {
	    	 StringTokenizer st = new StringTokenizer(br.readLine());	 
	    	 for(int j=0; j<N; j++) {
	    		 int tmp = Integer.parseInt(st.nextToken());
	    		 
	    		 if(tmp == 9) {
	    			 shark = new fish(i,j,2,0,0);
	    			 map[i][j] = 0;
	    			 continue;
	    		 }
	    		 
	    		 if(tmp ==1) {  // 바로 먹을 수 있는 먹이가 있을때
	    			 fishes.add(new fish(i,j,0,0,0));
	    		 }
	    		 
	    		 map[i][j] = tmp;
	    	 }
	     }
	     
	     if(fishes.isEmpty()) {		// 처음부터 먹을게 없다..
	    	 System.out.println(0);
	    	 return;
	     }
	     
	     // 우선순위 큐 생성
	     // 1. 거리가 가까운가?
	     // 2. 행값이 작은가?
	     // 3. 열값이 작은가?
	     PriorityQueue<fish> pq = new PriorityQueue<fish>(new Comparator<fish>() {
	    	 public int compare(fish o1, fish o2) {
	    		 if(o1.dis == o2.dis) {
	    			 if(o1.x == o2.x) {
	    				 return o1.y - o2.y;
	    			 } else {
	    				 return o1.x - o2.x;
	    			 }
	    		 } else {
	    			 return o1.dis  - o2.dis;
	    		 }
	    	 }
		});
	     
	    // bfs 탐색용 큐
	    Queue<fish> q = new LinkedList<>();
	    q.offer(shark);
	    
	    int z = 1;
	    while(z>0) {
	    	boolean[][] visited = new boolean [N][N];
	    	visited[q.peek().x][q.peek().y] = true;
	    	
	    	while(!q.isEmpty()) {
	    		fish f = q.poll();
	    		
	    		// 현재 상어의 좌표
	    		int tmpx = f.x;
	    		int tmpy = f.y;
	    		
	    		for(int i=0; i<4; i++) {	// 상하좌우 탐색
	    			int movex = dx[i] + tmpx;
	    			int movey = dy[i] + tmpy;
	    			
	    			if(movex < 0 || movex >=N || movey <0 || movey >=N || map[movex][movey] > f.size || visited[movex][movey]) {
	    				continue;		// 배열의 범위를 벗어난 값 or 방문한 곳 or 몸집보다 큰 먹이라면 지나친다
	    			}
	    			
	    			if(map[movex][movey] < f.size && map[movex][movey] != 0) {
	    				pq.offer(new fish(movex,movey,f.size,f.eatCnt+1,f.dis+1));
	    				// 먹이라고 판단되면 우선순위 큐에 먹이의 정보 저장한다
	    			}
	    			
	    			// 아기 상어 이동
	    			q.offer(new fish(movex, movey,f.size,f.eatCnt,f.dis+1));
	    			visited[movex][movey] = true;
	    			
	    		}
	    	}
	    	
	    	// 더 이상 먹을게 없다?
			if(pq.isEmpty()) {
				System.out.println(result);
				return;
			}
			
			fish f = pq.poll();
			if(f.size == f.eatCnt) {	// 먹이를 적절하게 먹었다면 레벨업 
				f.size++;
				f.eatCnt = 0;
			}
			
			map[f.x][f.y] = 0;  // 먹은 곳 청소
			result += f.dis;	// 출발한 곳에서 먹은 곳 까지 거리 더해주기
			q.offer(new fish(f.x, f.y, f.size, f.eatCnt, 0));	// 다시 먹은 곳에서 출발
			pq.clear();			// 먹이는 1개만 먹을 수 있으므로 다시 탐색을 위해 비워주기
			
	    }
	}

}
