package com.ssafy.a;

import java.io.*;
import java.util.*;

class Solution {
	static int n, m;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(from).append(", ").append(to).append(", ").append(weight)
					.append("]");
			return builder.toString();
		}
		
	}

	static void make() {
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int num) {
		
		if(parents[num] == num)
			return num;
		
		return parents[num] = findSet(parents[num]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b); 
		if(aRoot == bRoot)		
			return false;
		int Min_Parent = Math.min(aRoot, bRoot);	
		parents[aRoot] = Min_Parent;	
		parents[bRoot] = Min_Parent;	
		return true;
	}
	
	public static void main(String []args) throws Exception {  
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	int tc = stoi(br.readLine());
    	
    	for(int tidx = 1; tidx <= tc; tidx++) {
    		stk = new StringTokenizer(br.readLine());
    		n = stoi(stk.nextToken());
    		m = stoi(stk.nextToken());
    		edgeList = new Edge[m];
    		parents = new int[n + 1];
    		
    		for(int i = 0; i < m; i++) {
    			stk = new StringTokenizer(br.readLine());
    			edgeList[i] = new Edge(stoi(stk.nextToken()), stoi(stk.nextToken()), stoi(stk.nextToken()));
    		}
    		
    		Arrays.sort(edgeList);
    		
    		
    		make();
        	long result = 0;
        	int count = 0; 
        	
        	for(Edge edge : edgeList) {
        		if(union(edge.from, edge.to)) {		
        			result += edge.weight;
        			if(++count == n - 1) {
        				break;
        			}
        		}
        	}
    		
    		System.out.println("#" + tidx + " " + result);
    	}
    	
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}