package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_D3_1225_암호생성기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder();
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp = 1;
			
			for(int j=0;  j<8; j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(tmp > 0) {
				
				for(int k =1; k<6; k++) {
					tmp = q.peek();
					q.poll();
					tmp -= k;
					
					if(tmp <= 0) {
						tmp = 0;
						q.offer(tmp);
						break;
					}
					q.offer(tmp);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int j =0; j<8;j++) {
				sb.append(q.poll()).append(" ");
			}
			System.out.println(sb);
		}

	}

}
