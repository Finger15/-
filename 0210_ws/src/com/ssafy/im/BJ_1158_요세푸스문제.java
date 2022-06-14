package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1158_요세푸스문제 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();		
		int size = Integer.parseInt(st.nextToken());
		int kill = Integer.parseInt(st.nextToken());
		
		Queue<Integer> josephus = new LinkedList<Integer>();	// 요세푸스 큐
		Queue<Integer> print = new LinkedList<Integer>();		// 정답큐
		
		for(int i = 1; i<= size; i++) {
			josephus.offer(i);
		}
		
		int index = 1;
		while(print.size() < size) {				// 인덱스와 일치하지 않은 값은 다시 큐의 백으로 넣어준다
			if(index < kill) {
				josephus.offer(josephus.poll());
				index++;
			}
				
			else if(index == kill) {				// 인덱스가 일치하면 그 값을 print큐에 넣어준다
				print.offer(josephus.poll());
				index = 1;
			}
		}
		
		sb.append("<");
		
		for(int i=0; i<size; i++) {
			sb.append(print.poll()).append(",").append(" ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.print(sb.toString());	
	}
}
