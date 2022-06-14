package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		System.setIn(new FileInputStream("input_D3_3499_퍼펙트셔플.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if(N%2==0) {	// N이 짝수인 경우
				for(int i =0; i<N/2;i++) {
					q1.add(st.nextToken());
				}
				for(int i=N/2 ; i<N; i++) {
					q2.add(st.nextToken());
				}
				
				for(int i=0; i<N/2; i++) {
					sb.append(q1.poll()).append(" ").append(q2.poll()).append(" ");
				}
			}
			else {		// N이 홀수인 경우
				for(int i=0; i<=N/2;i++) {
					q1.add(st.nextToken());
				}
				
				for(int i=N/2+1 ; i<N; i++) {
					q2.add(st.nextToken());
				}
				for(int i=0; i<N/2; i++) {
					sb.append(q1.poll()).append(" ").append(q2.poll()).append(" ");
				}
				sb.append(q1.poll());
			}
			System.out.println(sb);
		}
	}

}
