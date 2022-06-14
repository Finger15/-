import java.util.*;
import java.io.*;


public class DijkstraTest {

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
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;		// 시작점 0으로
		
		for (int i = 0; i < V; i++) {
			// 1단계 :  최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE, current = 0;
			for(int j=0; j<V; j++) {
				if(!visited[j] && min> distance[j]) {
					min = distance[j];
					current =j;
				}
			}
			visited[current] = true;
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > distance[current] + adjMatrix[current][j]) {
					distance[j] = distance[current] + adjMatrix[current][j];
				}
				
			}
		}
		
		System.out.println(Arrays.toString(distance));

	}

}
