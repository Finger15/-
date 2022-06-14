import java.util.*;
import java.io.*;

public class DijkstraTest1 {
	
	static class Vertex implements Comparable<Vertex>{
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		StringTokenizer st = null;
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];			// 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V];		// 최소비용 확정여부
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;		// 시작점 0으로
		pq.offer(new Vertex(start,distance[start]));
		
		
		while(!pq.isEmpty()) {
			// 1단계 :  최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pq.poll();
			
			if(visited[current.no]) continue;
			visited[current.no] = true;
			
			// 2단계 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정 되지 않은 다른정점의 최소비용을 고려
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current.no][j] != 0 && distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pq.offer(new Vertex(j, distance[j]));
				}
				
			}
		}
		
		System.out.println(Arrays.toString(distance));


	}

}
