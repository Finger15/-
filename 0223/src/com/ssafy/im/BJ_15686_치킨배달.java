package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_15686_치킨배달 {
	
	static class house{
		int x;
		int y;
	
		public house(int x, int y) {
			
			this.x = x;
			this.y = y;
			
		}
		
	}
	
	static int N, M;
	static List<house> c_list;
	static List<house> h_list;
	static Stack<house> visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		c_list = new ArrayList<>();
		h_list = new ArrayList<>();
		visited = new Stack<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if(tmp == 2) {
					c_list.add(new house(i,j));	
				}
				
				else if(tmp ==1) {
					h_list.add(new house(i,j));
				}
			}
		}
	
		search(0, 0);
		System.out.print(result);
		
	}

	public static void search (int cnt , int start ) {
		
		if(cnt == M) {
			getDis();
			return;
		}
		
		for(int i= start; i<c_list.size(); i++) {
			visited.push(c_list.get(i));
			search(cnt+1, i+1);
			visited.pop();
		}
		
	}

	private static void getDis() {
		int sum = 0;
		
		for(house h : h_list) {
			int min_value = Integer.MAX_VALUE;
			for(house c : visited) {
				int dis = Math.abs(h.x - c.x) + Math.abs(h.y- c.y);
				min_value = Math.min(min_value, dis);
			}
			sum += min_value;
			
			if(sum > result) {
				return;
			}
		}
		
		result = Math.min(result, sum);
	}
	
}
