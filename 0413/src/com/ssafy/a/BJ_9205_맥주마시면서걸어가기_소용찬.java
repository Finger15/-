package com.ssafy.a;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class BJ_9205_맥주마시면서걸어가기_소용찬 {
	static int N;    
	static Point arr[];
	static boolean visit[];
	static ArrayList<Integer> arrList[];

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int testCases = Integer.parseInt(br.readLine());
	        for(int tc=0; tc<testCases; tc++) {
	            N = Integer.parseInt(br.readLine());
	            
	            arrList = new ArrayList[N+2];
	            visit = new boolean[N+2];
	            for(int i=0; i<N+2; i++)
	                arrList[i] = new ArrayList<>();
	            
	            arr = new Point[N+2];
	            
	            StringTokenizer st;
	            
	            for(int i=0; i<N+2; i++) {
	                st = new StringTokenizer(br.readLine());
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                
	                arr[i] = new Point(x,y);
	            }
	            
	            for(int i=0; i<N+1; i++) {
	                for(int j=i+1; j<N+2; j++) {
	                    float dist = (float) ((Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y -arr[j].y))/50.0);
	                    if(dist <= 20) {
	                        arrList[i].add(j);
	                        arrList[j].add(i);
	                    }
	                }
	            }
	            
	            if(bfs())
	                System.out.println("happy");
	            else
	                System.out.println("sad");
	        }
	}
	        
	        private static boolean bfs() {

	            Queue<Integer> queue = new LinkedList<>();
	            queue.add(0);
	            visit[0] = true;
	            
	            while(!queue.isEmpty()) {
	                int index =queue.poll();

	                if(index == N+1)
	                    return true;
	                
	                for(int i=0; i<arrList[index].size(); i++) {

	                    if(!visit[arrList[index].get(i)]) {
	                        visit[arrList[index].get(i)] = true;
	                        queue.add(arrList[index].get(i));
	                    }
	                }
	            }
	            return false;
	        }

}
