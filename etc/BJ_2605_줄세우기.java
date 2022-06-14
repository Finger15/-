package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()), i+1);	
		}
		
		for(int i=N-1; i>=0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
